document.addEventListener("DOMContentLoaded", function() {
    const summary = document.querySelector("#summary")
    summary.addEventListener("click", function (event) {

        const category = document.querySelectorAll("[name='categories']:checked");
        const tab = [];
        category.forEach(e=>tab.push(e.parentElement.lastElementChild.innerText));

        const institution = document.querySelector("[name='institution']:checked")
        const ins = institution.parentElement.lastElementChild.firstElementChild;

        document.querySelector("#city").textContent = document.querySelector("#cityInput").value;
        document.querySelector("#zipCode").textContent = document.querySelector("#zipCodeInput").value;
        document.querySelector("#street").textContent = document.querySelector("#streetInput").value;
        document.querySelector("#date").textContent = document.querySelector("#dateInput").value;
        document.querySelector("#time").textContent = document.querySelector("#timeInput").value;
        document.querySelector("#comment").textContent = document.querySelector("#commentInput").value;
        document.querySelector("#content").textContent = document.querySelector("#quantityInput").value + " worki ("+ tab + ")";
        document.querySelector("#institution").textContent = ins.innerText + " - " + ins.nextElementSibling.innerText ;


    } );
});
