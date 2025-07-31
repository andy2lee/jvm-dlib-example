# jvm-dlib-example
dlib example for jvm lang. java/kotlin

# Run Program (Windows platform) (JDK 23 ffm panama access to native)
1. Download dlib zip on official website.
2. extract dlib zip
3. `cd dlib-20.0/examples`
4. `mkdir build` and `cd build`
5. `cmake ..` and `cmake --build . --config Release`
6. replace CMakeLists.txt in dlib-20.0/examples
7. `cmake --build . --config Release`
9. `cd Release` and get dlibintf.dll
10. copy `jvm-dlib-example/dlib-20.0/examples/Release` to `dlib-20.0/examples/build/Release` folder
11. javac -cp . App.java or kotlinc -cp . App.kt
12. java -cp . App or kotlin -cp . Appkt
