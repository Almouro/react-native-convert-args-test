/**
 * @format
 */

import {AppRegistry, NativeModules} from 'react-native';
import App from './App';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => App);

NativeModules.Bridge.getBundle().then((bundle) =>
  console.log('bundle', bundle),
);
NativeModules.Bridge.getList().then((list) => console.log('list', list));
NativeModules.Bridge.getArray().then((array) => console.log('array', array));
