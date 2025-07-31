#include <dlib/image_processing/frontal_face_detector.h>
#include <dlib/gui_widgets.h>
#include <dlib/image_io.h>
#include <iostream>

#define WIN_DLL_EXPORT __declspec(dllexport)
using namespace dlib;
using namespace std;

extern "C" {
    WIN_DLL_EXPORT frontal_face_detector* dlib_get_frontal_face_detector(void);
    WIN_DLL_EXPORT void dlib_get_frontal_face_detector_del(frontal_face_detector*);
    WIN_DLL_EXPORT image_window* dlib_image_window(void);
    WIN_DLL_EXPORT void dlib_image_window_del(image_window*);
    WIN_DLL_EXPORT array2d<unsigned char>* dlib_array2d(void);
    WIN_DLL_EXPORT void dlib_array2d_del(array2d<unsigned char>*);
    WIN_DLL_EXPORT void dlib_load_image(array2d<unsigned char>*, char*);
    WIN_DLL_EXPORT void dlib_pyramid_up(array2d<unsigned char>*);
    WIN_DLL_EXPORT std::vector<dlib::rectangle>* dlib_detector_dets(frontal_face_detector*, dlib::array2d<unsigned char>*);
    WIN_DLL_EXPORT void dlib_detector_dets_del(std::vector<dlib::rectangle>*);
    WIN_DLL_EXPORT int dlib_dector_dets_size(std::vector<dlib::rectangle>*);
    WIN_DLL_EXPORT void dlib_image_window_clear_overlay(dlib::image_window*);
    WIN_DLL_EXPORT void dlib_image_window_set_image(dlib::image_window*, dlib::array2d<unsigned char>*);
    WIN_DLL_EXPORT void dlib_image_window_add_overlay(dlib::image_window*, std::vector<dlib::rectangle>*, dlib::rgb_pixel*);
    WIN_DLL_EXPORT dlib::rgb_pixel* dlib_rgb_pixel(int, int, int);
    WIN_DLL_EXPORT void dlib_rgb_pixel_del(dlib::rgb_pixel*);
}
