document.addEventListener("init", function(event) {
    var page = event.target;
    if (page.id === "page1") {
        page.querySelector("#paste-button").onclick = function() {
            paste();
        };
    } else if (page.id === "page2") {
        var title = page.data.response.title;
        page.querySelector("ons-toolbar .center").innerHTML = "<b>" + ((title.length ==
            0) ? "Untitled paste" : title) + " </b>";
        page.querySelector(".paste-text").innerHTML = page.data.response.content;
        document.getElementById("paste-syntax").classList.add("language-" + page.data.response.syntax);
        document.getElementById("paste-syntax").classList.add("line-numbers");
        Prism.highlightAll();
        page.querySelector("#copy-button").setAttribute("data-clipboard-text",
            calculatePasteURL(page.data.response.id));
        var clipboard = new ClipboardJS("#copy-button");
    } else if (page.id === "paste") {
        var pasteId = window.location.pathname.split("/")[2];
        populatePasteOnPage(pasteId, page);
    }
});

function paste() {
    var formTitle = document.getElementById("paste-title").value
    var formContent = document.getElementById("paste-content").value
    var formSyntax = document.getElementById("choose-sel").value;
    var payload = { title: formTitle, content: formContent, syntax: formSyntax }

    fetch("/pastes", {
            method: "POST",
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            return response.json()
        })
        .then(json => {
            document.querySelector("#myNavigator").pushPage("page2.html", { data: { response: json } })
        }).catch(error => {
            console.log(error),
                ons.notification.alert("Failed to submit the paste!");
        });
}

function calculatePasteURL(responseId) {
    return window.location.protocol +
        "//" + window.location.hostname + ":" + window.location.port + "/" +
        "pastes" + "/" +
        responseId;
}

function populatePasteOnPage(pasteId, page) {

    fetch("/pastes/raw/" + pasteId)
        .then(response => {
            if (response.status === 404) {
            	document.querySelector("#myNavigator").pushPage("paste_not_found.html", { data: { response: "hello world"} })
            } else {
                response.json().then(json => {
                    page.querySelector("ons-toolbar .center").innerHTML = "<b>" + json.title + " </b>";
                    page.querySelector(".paste-text").innerHTML = json.content;
                    document.getElementById("paste-syntax").classList.add("language-" + json.syntax);
                    document.getElementById("paste-syntax").classList.add("line-numbers");
                    Prism.highlightAll();
                })
            }
        });
}