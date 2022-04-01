function addTask() {
    let taskToAdd = document.getElementById("taskInput").value;
    let tasksContainer = document.getElementById("tasksContainer");
    tasksContainer.innerHTML = tasksContainer.innerHTML +
        `
        <div class="task-container">
            <input type="button" class="done" onclick="markDone(this.parentNode)" value="&#x2713;"/>
            <input type="button" class="remove" onclick="remove(this.parentNode)" value="&#x2715;"/>
            <input type="button" class="important" onclick="important(this.parentNode)" value="!"/>
            <p class="task">${taskToAdd}</p>
        </div>
    `;
    removeAuthor();
}
function markDone(item) {
    item.className = "finished";
    removeAuthor();
}
function remove(item) {
    item.remove();
    removeAuthor();
}
function important (item) {
    item.className = "important-task";
}
function displayInfo() {
    let authorInfo = document.getElementById("authorInfo");
    authorInfo.innerHTML = '<p class="author">Abel Zazueta</p>'
}
function clearTasks(){
    let tasksContainer = document.getElementById("tasksContainer");
    tasksContainer.innerHTML="";
    removeAuthor();
}
function removeAuthor(){
    let authorInfo = document.getElementById("authorInfo");
    authorInfo.innerHTML="";
}