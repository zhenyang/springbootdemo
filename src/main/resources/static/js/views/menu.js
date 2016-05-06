require('backbone');
var $ = require('jquery');
var _ = require('underscore');

var Menu = Backbone.View.extend({
    template: _.template($('#tpl-menu').html()),
    initialize: function() {
        this.render();
    },
    render: function () {
        this.$el.html(this.template({}));
    }
});

module.exports = Menu;