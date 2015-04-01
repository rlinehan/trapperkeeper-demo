# trapperkeeper-demo

This repository contains a simple Trapperkeeper application that is based on the sample app created by the lein TK plugin. It involves cats ( <3 :3 <3 ) and is intended to show off the following features of TK:

 * multiple implementations of a given service (see `MeowService`)
 * storing state in context (using the `meowdb.json` flatfile)
 * basic web routing
 * configuration via hocon
 * bootstrap.cfg
 * basic service testing

This was created for the _One Binder to Rule Them All_ talk at Clojure/west 2015 but the hope is it can be reused for other TK talks (by anyone who\'d like to give one).


## Usage

This repo is largely intended to be screenshotted for code samples but is suitable for live demos, too. Ideally this repo will always be in a working state, complete with tests.

A simple _meow world_ web service can be run with:

`lein tk`

Then, open a browser and visit:

http://localhost:8080/meow/world

## License

Copyright © 2015 Puppet Labs

Distributed under the Apache Public License.

## Authors

 * Ruth Linehan
 * Nathaniel Smith

