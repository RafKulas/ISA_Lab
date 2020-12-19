import {getParameterByName} from '../../js/dom_utils.js';
import {getBackendUrl} from '../../js/configuration.js';

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => updateInfoAction(event));
    fetchAndDisplayStudent();
});

function fetchAndDisplayStudent() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            for (const [key, value] of Object.entries(response)) {
                let input = document.getElementById(key);
                if (input) {
                    input.value = value;
                }
            }
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/students/' + getParameterByName('student'), true);
    xhttp.send();
}

function updateInfoAction(event) {
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        //console.log(`State: ${this.readyState}, status: ${this.status}`)
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayStudent();
            window.alert("Student changed!")
        }
    };
    xhttp.open("PUT", getBackendUrl() + '/api/students/' + getParameterByName('student'), true);

    const request = {
        'name': document.getElementById('name').value,
        'surname': document.getElementById('surname').value,
        'fieldOfStudies': document.getElementById('fieldOfStudies').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}
