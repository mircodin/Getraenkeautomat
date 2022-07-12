/**
 * view-controller for getraenkautomatlist.html
 * @author Mirco Di Natale
 */
document.addEventListener("DOMContentLoaded", () => {
    readGetraenkeautomaten();
});

/**
 * reads all getraenkeautomaten
 */
function readGetraenkeautomaten() {
    fetch("./resource/getraenkeautomat/list")
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showGetraenkeautomatlist(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * shows the getraenkeautomatlist as a table
 * @param data the getraenkeautomaten
 */
function showGetraenkeautomatlist(data) {
    let tBody = document.getElementById("getraenkeautomatlist");
    data.forEach(getraenkeautomat => {
        let row = tBody.insertRow(-1);
        row.insertCell(-1).innerHTML = getraenkeautomat.modellnummer;
        row.insertCell(-1).innerHTML = getraenkeautomat.farbe;

        let button = document.createElement("button");
        button.innerHTML = "LÃ¶schen";
        button.type = "button";
        button.name = "deleteGetraenkeautomat";
        button.setAttribute("data-getraenkeautomatuuid", getraenkeautomat.getraenkeautomatUUID);
        button.addEventListener("click", deleteGetraenkeautomat);

        row.insertCell(-1).appendChild(button);
    });
}

/**
 * deletes an getraenkeautomat
 * @param event the click-event
 */
function deleteGetraenkeautomat(event) {
    const button = event.target;
    const getraenkeautomatUUID = button.getAttribute("data-getraenkeautomatuuid");

    fetch("./resource/getraenkeautomat/delete?uuid=" + getraenkeautomatUUID,
        {
            method: "DELETE"
        })
        .then(function (response) {
            if (response.ok) {
                window.location.href = "./getraenkeautomatlist.html";
            } else {
                console.log(response);
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}