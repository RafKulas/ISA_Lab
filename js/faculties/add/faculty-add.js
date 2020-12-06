import {getBackendUrl} from '../../js/configuration.js';

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => addFaculty(event));
});

function addFaculty(event) {
    event.preventDefault();

    const name = document.forms["infoForm"]["name"].value;
    const dean = document.forms["infoForm"]["dean"].value;
    const numberOfStudents = document.forms["infoForm"]["numberOfStudents"].value;

    if(name === "" && dean === "" && numberOfStudents === "") {
        window.alert("Fill all inputs!")
    }
    else {
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 201) {
                alert("Faculty added!")
                window.location.href = "../list/faculties-list.html"
            }
        };

        xhttp.open("POST", getBackendUrl() + '/api/faculties', true);

        const request = {
            'name': document.getElementById('name').value,
            'numberOfStudents': parseInt(document.getElementById('numberOfStudents').value),
            'dean': document.getElementById('dean').value
        };

        xhttp.setRequestHeader('Content-Type', 'application/json');

        xhttp.send(JSON.stringify(request));
    }
}
