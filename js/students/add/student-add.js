import {getBackendUrl} from '../../js/configuration.js';
import {getParameterByName} from "../../js/dom_utils.js";

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => addStudent(event));
});

function addStudent(event) {
    event.preventDefault();

    const name = document.forms["infoForm"]["name"].value;
    const surname = document.forms["infoForm"]["surname"].value;
    const fieldOfStudies = document.forms["infoForm"]["fieldOfStudies"].value;
    const indexNumber = document.forms["infoForm"]["indexNumber"].value;

    if(name === "" && surname === "" && fieldOfStudies === "" && indexNumber === "") {
        window.alert("Fill all inputs!")
    }
    else {
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            console.log(`State: ${this.readyState}, Status: ${this.status}`)
            if (this.readyState === 4 && this.status === 201) {
                alert("Student added!")
                window.location.href = `../../faculties/view/faculty-view.html?faculty=${getParameterByName('faculty')}`
            }
        };

        xhttp.open("POST", getBackendUrl() + '/api/students', true);

        const request = {
            'indexNumber': parseInt(document.getElementById('indexNumber').value),
            'name': document.getElementById('name').value,
            'surname': document.getElementById('surname').value,
            'fieldOfStudies': document.getElementById('fieldOfStudies').value,
            'faculty' : getParameterByName('faculty')
        };

        xhttp.setRequestHeader('Content-Type', 'application/json');

        xhttp.send(JSON.stringify(request));
    }
}
