document.addEventListener("init", function(event) {
  var page = event.target;
  if (page.id === "page1") {
    page.querySelector("#paste-button").onclick = function() {
      paste();
    };
  } else if (page.id === "page2") {
    page.querySelector("ons-toolbar .center").innerHTML = page.data.title;
    page.querySelector("#responsediv").innerHTML = page.data.response;
  }
});

function paste() {
  var formTitle = document.getElementById("paste-title").value
  var formContent = document.getElementById("paste-content").value
  var payload = { title: formTitle, content: formContent }

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
    document.querySelector("#myNavigator").pushPage("page2.html", { data: { title: "Response:", response: JSON.stringify(json) } })
  }).catch(error => {
    console.log(error),
    ons.notification.alert("Failed to submit the paste!");
});
}
