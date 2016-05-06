require('backbone');
var $ = require('jquery');
var ToDos = require('./collections/todos');
var MenuView = require('./views/menu');
var ListView = require('./views/list');

var app = (function () {

    var api = {
        views: {},
        models: {},
        collections: {},
        content: null,
        router: null,
        todos: null,
        init: function () {
            this.content = $("#content");
            ViewsFactory.menu();
            this.todos = new ToDos();
            Backbone.history.start();
            return this;
        },
        changeContent: function (el) {
            this.content.empty().append(el);
            return this;
        },
        title: function (str) {
            $("h1").text(str);
            return this;
        }
    };
    var ViewsFactory = {
        menu: function() {
            if(!this.menuView) {
                this.menuView = new MenuView({
                    el: $("#menu")
                });
            }
            return this.menuView;
        },
        list: function() {
            if(!this.listView) {
                this.listView = new ListView({
                    model: api.todos
                });
            }
            return this.listView;
        }
    };

    var Router = Backbone.Router.extend({
        routes: {
            "archive": "archive",
            "new": "newToDo",
            "edit/:index": "editToDo",
            "delete/:index": "delteToDo",
            "list": "list"
        },
        list: function(archive) {
            var view = ViewsFactory.list();
            api.title(archive ? "Archive:" : "Your ToDos:").changeContent(view.$el);
            view.setMode(archive ? "archive" : null).render();
        },
        archive: function() {
            this.list(true);
        }
    });

    api.router = new Router();

    return api;

})();

$(function(){
    app.init();
});