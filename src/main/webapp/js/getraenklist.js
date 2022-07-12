/**
 * view-controller for getraenkautomatlist.html
 * @author Mirco Di Natale
 */
document.addEventListener("DOMContentLoaded", () => {
    readGetraenke();
});

/**
 * reads all getraenkeautomaten
 */
function readGetraenke() {
    fetch("./resource/getraenk/list")
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showGetraenklist(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * shows the getraenkeautomatlist as a table
 * @param data the getraenkeautomaten
 */
function showGetraenklist(data) {
    let tBody = document.getElementById("getraenklist");
    data.forEach(getraenk => {
        let row = tBody.insertRow(-1);
        row.insertCell(-1).innerHTML = getraenk.bezeichnung;
        row.insertCell(-1).innerHTML = getraenk.preis;
        row.insertCell(-1).innerHTML = getraenk.inhaltInML;
        row.insertCell(-1).innerHTML = getraenk.ablaufdatum;


        let button = document.createElement("button");
        button.innerHTML = "LÃ¶schen";
        button.type = "button";
        button.name = "deleteGetraenk";
        button.setAttribute("data-getraenkuuid", getraenk.getraenkUUID);
        button.addEventListener("click", deleteGetraenk);

        row.insertCell(-1).appendChild(button);
    });
}

/**
 * deletes an getraenkeautomat
 * @param event the click-event
 */
function deleteGetraenk(event) {
    const button = event.target;
    const getraenkUUID = button.getAttribute("data-getraenkuuid");

    fetch("./resource/getraenk/delete?uuid=" + getraenkUUID,
        {
            method: "DELETE"
        })
        .then(function (response) {
            if (response.ok) {
                window.location.href = "./getraenklist.html";
            } else {
                console.log(response);
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}