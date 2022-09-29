##Build Tools and Versions Used
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:3.14.7'
    implementation 'androidx.compose.ui:ui-tooling:1.1.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation 'androidx.compose.ui:ui-tooling-preview:1.2.0-beta02'
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'com.squareup.picasso:picasso:2.71828'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

     defaultConfig:

            applicationId "com.example.myemployment"
            minSdk 28
            targetSdk 31
            versionCode 1
            versionName "1.0"

     ##Steps to run app

     1) unzip project
     2)Open Android Studio
     3)Go to File - > Open
     4)Browse to the project location.
     5)Select build.gradle and open.
     6)to reload list click on the recyclerview

    ## What areas of the app did you focus on?
    I focused on the UI and getting the main required functionality met

    ## What was the reason for your focus? What problems were you trying to solve?
    My reason to focus on those areas of the app, were because I wanted to display my ability design
    UI based on material design, and ensure the requirements were met.
    As well as show my skill with all the other aspects of the project like Json parsing.recyclerview

    ## How long did you spend on this project?
    I spend a total of 4 hours and 30 mins on the project.

    ## Did you make any trade-offs for this project? What would you have done differently with more time?
    Tradeoffs that I made were mostly in relation to the json factory converter, I choose gson because I have used it more in other projects,
    I would have liked to used other libraries like moshi, since it is faster and more powerful. I could have designed my owned Jsonadapter to handle
    better malformed json data and efficiency of the factory converter. I spend a good part of my time on the UI aspect of the app as well,
    it was more like how I wanted to show the data of the app. I kept rearranging some views. I would have also designed my own disk image caching solution
    I ended up using picasso since it automatically caches to disk. With more time I would have structured the app better as well, with a design pattern.

    I would have also switched to jetpack compose instead of xml, I feel like jetpack compose would have helped me speed up the UI design process.

    ## What do you think is the weakest part of your project?
    the weakest part of my project is my unit testing, I feel like I didn't test enough aspects as I felt I was running out of time.
    I also spent the least amount of time in this part of the project.

    ## Is there any other information you’d like us to know?
    In regards to other information I just wanted to say that it was a very engaging project and I enjoyed working on it.
    I enjoy building projects on my free time and learning of the best and most efficient android developement tools.


