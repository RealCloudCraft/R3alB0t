var request = require('request');
var lib = require('../../../lib');


var user_info = function(bot, message, author, channel, server) {
    request("https://osu.ppy.sh/api/get_user?k=1dcd91f3c13befee76760193f82965bd59b4b996&u=" + author.username, function(error, res, body) {
        if (body != null) {
            body = JSON.parse(body);
            console.log(body);
            
            if (body.length == 0) {
                message.reply("Could find stats for `" + author.username + "`");
            } else {
                bot.sendMessage(channel);
            }
        } else {

        }
    });
};

exports.registerCMD = function(CommandRegistry, plugin) {
    CommandRegistry.registerPrefix(plugin, "#$");
    CommandRegistry.registerCommand(plugin, 'userinfo', ['uinfo', 'userinfo', 'user_info', 'useri'], "Gets your osu! stats from osu!'s servers", user_info, "@everyone");

}
