var $ = require('jquery');
var Menu = require('./views/menu');

var ViewsFactory = {
    menu: function () {
        if (!this.menuView) {
            this.menuView = new Menu({
                el: $("#menu")
            });
        }
        return this.menuView;
    }
};

module.exports = ViewsFactory;