cmake_minimum_required(VERSION 3.10.0)

project(examples)
add_subdirectory(../dlib dlib_build)

add_library(dlibintf SHARED dlibintf.cpp)
target_link_libraries(dlibintf dlib::dlib)
