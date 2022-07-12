/**
 * view-controller for getraenkedit.html
 * @author Saranya Wenger
 */
document.addEventListener("DOMContentLoaded", () => {
    readMarken();
    readGetraenk();

    document.getElementById("getraenkeditForm").addEventListener("submit", saveGetraenk);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of a getränk
 * @param event
 */
function saveGetraenk(event) {
    event.preventDefault();

    const getraenkForm = document.getElementById("getraenkeditForm");
    const formData = new FormData(getraenkForm);
    const data = new URLSearchParams(formData)

    let method;
    let url = "./resource/getraenk/";
    const getraenkUUID = getQueryParam("uuid")
    if (getraenkUUID == null) {
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
 * reads a getraenk
 */
function readGetraenk() {
    const getraenkUUID = getQueryParam("uuid");
    fetch("./resource/getraenk/read?uuid=" + getraenkUUID)
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showGetraenk(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * show the data of a getraenk
 * @param data  the getraenk-data
 */
function showGetraenk(data) {
    document.getElementById("getraenkUUID").value = data.getraenkUUID;
    document.getElementById("bezeichnung").value = data.title;
    document.getElementById("preis").value = data.preis;
    document.getElementById("inhaltInML").value = data.inhaltInML;
    document.getElementById("ablaufdatum").value = data.ablaufdatum;
    document.getElementById("marke").value = data.markeUUID;


}

/**
 * reads all marken as an array
 */
function readMarken() {

    fetch("./resource/marke/list")
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showMarken(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * show all makren as a dropdown
 * @param data
 */
function showMarken(data) {
    let dropdown = document.getElementById("marke");
    data.forEach(marke => {
        let option = document.createElement("option");
        option.text = marke.bezeichnung;
        option.value = marke.markeUUID;
        dropdown.add(option)
    })
}

/**
 * redirects to the getraenklist.html
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "./getraenklist.html";
}