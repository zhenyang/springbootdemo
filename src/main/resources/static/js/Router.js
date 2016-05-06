require('backbone');

var Router = Backbone.Router.extend({
    routes: {
        "archive": "archive",
        "new": "newToDo",
        "edit/:index": "editToDo",
        "delete/:index": "deleteToDo",
        "": "list"
    },
    list: function(archive) {},
    archive: function() {},
    newToDo: function() {},
    editToDo: function(index) {},
    deleteToDo: function(index) {}
});
module.exports = Router;