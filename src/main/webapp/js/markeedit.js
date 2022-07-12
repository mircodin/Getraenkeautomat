/**
 * view-controller for markeedit.html
 * @author Mirco Di Natale
 */
document.addEventListener("DOMContentLoaded", () => {
    readMarke();

    document.getElementById("markeeditForm").addEventListener("submit", saveMarke);
    document.getElementById("cancel").addEventListener("click", cancelEdit);
});

/**
 * saves the data of an marke
 * @param event
 */
function saveMarke(event) {
    event.preventDefault();

    const markeForm = document.getElementById("markeeditForm");
    const formData = new FormData(markeForm);
    const data = new URLSearchParams(formData)

    let method;
    let url = "./resource/marke/";
    const markeUUID = getQueryParam("uuid")
    if (markeUUID == null) {
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
 * reads an marke
 */
function readMarke() {
    const markeUUID = getQueryParam("uuid");
    fetch("./resource/marke/read?uuid=" + markeUUID)
        .then(function (response) {
            if (response.ok) {
                return response;
            } else {
                console.log(response);
            }
        })
        .then(response => response.json())
        .then(data => {
            showMarke(data);
        })
        .catch(function (error) {
            console.log(error);
        });
}

/**
 * show the data of an marke
 * @param data  the marke-data
 */
function showMarke(data) {
    document.getElementById("markeUUID").value = data.markeUUID;
    document.getElementById("bezeichnung").value = data.bezeichnung;
    document.getElementById("hauptsitz").value = data.hauptsitz;
    document.getElementById("umsatz").value = data.umsatz;
    document.getElementById("telefonnummer").value = data.telefonnummer;
}

/**
 * redirects to getraenkeautomat.html
 * @param event  the click-event
 */
function cancelEdit(event) {
    window.location.href = "./getraenkeautomat.html";
}