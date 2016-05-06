var webpack = require('webpack');

module.exports = {
    entry: './src/main/resources/static/js/App.js',
    output: {
        path: './src/main/resources/static/js/',
        filename: 'bundle.js'
    },
    // module: {
    //     loaders: [
    //         {test: /\.css$/, loader: 'style!css'}
    //     ]
    // }
};