This is an example app for [my](https://twitter.com/botteaap) "Embracing Fragmentation" talk that I gave at [Mobile Down South](http://www.mobiledownsouth.nl/8/sprekers.html#HugoVisser) and [mdevcon](http://mdevcon.com/2012/01/10/hugo-visser/).

The app shows the screen class, dpi, the screen size and the available space or view size  of an Android in both pixels and device independent pixels (dips).

The goal of the app is to show you which technical mechanisms Android has to help you create apps that run on many devices:

 - The app consists of a single Activity containing a Fragment to (trivially) show how you can reuse UI and UI behaviour.
 - The main background is a gradient, defined in a [drawable xml](https://bitbucket.org/hvisser/sizemeup/src/3e5dbf5281d0/res/drawable/background.xml). Scaling gradients contained in a bitmap will result in visible artifacts, but since a drawable is rendered at runtime, it will always show nice and crisp, no matter what the screen size of device is.
 - The arrows that indicate screen width and height are defined as 9 patch images, making them stretchable. There are variants for mdpi, hdpi and xhdpi screens (ldpi will get scaled down by Android).
 - There's no logic in the fragment to determine screen dpi or screen class; this is entirely controlled by referencing a string resource in the layout, keeping the code simple.
 - For "large" screens the font sizes are adjusted to cater for the larger screen. Two methods are demostrated: using dimensions referenced as a resource from the layout file and using a [style](https://bitbucket.org/hvisser/sizemeup/src/3e5dbf5281d0/res/values-large/style.xml) on the TextViews in the layout.
 - [Styles](https://bitbucket.org/hvisser/sizemeup/src/3e5dbf5281d0/res/values-v11/style.xml) are used to inherit from either Theme or Theme.Holo so that on newer devices running Android 3.x or up the ActionBar is shown and styled.

This only shows the tip of the iceberg of what is possible; the resource system is very powerful and keeps your code simple. I highly recommend to read up on [providing resources on the Android developer site](http://developer.android.com/guide/topics/resources/providing-resources.html)

Contact
-------
If you want to get in touch just [contact me on twitter](https://twitter.com/botteaap) or [visit the Qbus website](http://www.qbus-ict.nl) to see what we're up to.