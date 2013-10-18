// node.js helper script to read in Font Awesome CSS classes from font-awesome.css and print out Java enums
// for IconType class
//
// Usage:
// node fontawesome.js /path/to/font-awesome.css
//
// @author Sven Jacobs

var fs = require('fs'),
    file = process.argv[2],
    regex = /^\.(icon-([^:]+)):before/m;

fs.readFile(file, 'UTF-8', function (err, data) {
    if (err) throw err;

    var lines = data.split('\n'),
        result = [];

    lines.forEach(function (line) {
        var match = regex.exec(line);

        if (match) {
            result.push(match[2].toUpperCase().replace(/-/g, '_') + '("' + match[1] + '"),');
        }
    });

    result.sort();

    result.forEach(function (item) {
        console.log(item);
    });
});