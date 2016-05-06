require('backbone');

var ToDo = Backbone.Model.extend({
    defaults: {
        title: "ToDo",
        archived: false,
        done: false
    }
});

module.exports = ToDo;