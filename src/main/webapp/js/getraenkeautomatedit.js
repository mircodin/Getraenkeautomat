/**
 * view-controller for getraenkeautomatedit.html
 * @author Mirco Di Natale
 */
document.addEventListener("DOMContentLoaded", () => {
    readGetraenkeautomat();

    document.getElementById("getraenkeautomateditForm").addEventListener("submit", saveGetraenkeautomat);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of an getraenkeautomat
 * @param event
 */
function saveGetraenkeautomat(event) {
    event.preventDefault();

    const getraenkeautomatForm = document.getElementById("getraenkeautomateditForm");
    const formData = new FormData(getraenkeautomatForm);
    const data = new URLSearchParams(formData)

    let method;
    let url = "./resource/getraenkeautomat/";
    const getraenkeautomatUUID = getQueryParam("uuid")
    if (getraenkeautomatUUID == null) {
        method = "POST";
        url += "create";
    } else {
        method = "PUT";
        url += "update";
    }

    fetch(url,
        {
            method: method,
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: data
        })
        .then(function (response) {
            if (!response.ok) {
                console.log(response);
            } else return response;
        })
        .then()
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * reads an getraenkeautomat
 */
function readGetraenkeautomat() {
    const getraenkeautomatUUID = getQueryParam("uuid");
    fetch("./resource/getraenkeautomat/read?uuid=" +getraenkeautomatUUID)
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showGetraenkeautomat(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * show the data of an getraenkeautomat
 * @param data  the getraenkeautomat-data
 */
function showGetraenkeautomat(data) {
    document.getElementById("getraenkeautomatUUID").value = data.getraenkeautomatUUID;
    document.getElementById("modellnummer").value = data.modellnummer;
    document.getElementById("farbe").value = data.farbe;
}

/**
 * redirects to getraenkeautomat.html
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "./getraenkeautomat.html";
}