# Spinner2
Spinner2 is a re-implementation of the default Android's spinner, with a simple way for control selection behavior.

![ezgif com-video-to-gif](https://cloud.githubusercontent.com/assets/5351890/10418431/8b564e92-7063-11e5-9b9c-099655862944.gif)


<h3>Supported features</h3>

- Enable/Disable autostart call <b>```onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)```</b> after adapter is assigned: <b>```spinner.setAdapter(adapter, withAction);```</b> to a widget
- Enable/Disable call item click action after calling <b>```spinner.setSelection(withAction, pos);```</b> 

where <b>```withAction```</b> is a boolean flag for enable/disable call item click action

<h3>Setup</h3>
Step 1. Add the JitPack repository to your build file

 ```java
 repositories {
        maven { url "https://jitpack.io" }
    }
 ```
    
Step 2. Add the dependency in the form

  ```java
	dependencies {
	        compile 'com.github.scijoker:spinner2:1.0'
	}
 ```
	
<h3>How to use</h3>
	
Example in <b>```app```</b> module

License
--------

    Copyright 2015 Andrew Prayzner

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
