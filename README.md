# StepsIndicatorView
steps view pager indicator


## Overview

GIF image

## Download

### Step 1:
Add the JitPack repository to your build file.
 
 - Add it in your **Project** ```build.gradle``` at the end of repositories:
 
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

-  Add the dependency
```
dependencies {
    implementation 'com.github.HasanMhdAmin:StepsIndicatorView:v0.9.1'
}
```

## Usage
- XML:
```xml
    <amin.mhd.hasan.stepsindicator.StepsIndicatorView
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="5dp"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="10dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="10dp"
        app:indicatorSpacing="2dp"
        app:selectedColor="@color/colorAccent"
        app:unSelectedColor="#fff" />
```

| Attribute | Description |
| :----: | :----: |
| indicatorSpacing | the space between the indicators |
| selectedColor | indicator color for the current and previous pages |
| unSelectedColor | indicator color for the further pages |

- Java:

```java
StepsIndicatorView stepsIndicator = findViewById(R.id.stepsIndicatorView);
stepsIndicator.setupWithViewPager(betterViewPage);
```

you can also set ```StepsIndicatorView``` 's attributes by code

```java
//set space between indicators
stepsIndicator.setIndicatorSpacing(10);
//set selected indicators color
stepsIndicator.setSelectedColor(Color.GREEN);
//set unSelected indicators color
stepsIndicator.setUnSelectedColor(Color.WHITE);
```




# License

```
Copyright 2018 yuyakaido

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```