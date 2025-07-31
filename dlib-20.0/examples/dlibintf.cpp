#include "dlibintf.h"

#include "../dlib/array2d/array2d_kernel.h"
#include "../dlib/gui_widgets/widgets.h"

frontal_face_detector* dlib_get_frontal_face_detector(void) {
    return new frontal_face_detector(std::move(get_frontal_face_detector()));
}

void dlib_get_frontal_face_detector_del(frontal_face_detector* p_frontal_face_detector) {
    delete p_frontal_face_detector;
}

image_window* dlib_image_window(void) {
    return new image_window();
}

void dlib_image_window_del(image_window* p_image_window) {
    delete p_image_window;
}

array2d<unsigned char>* dlib_array2d(void) {
    return new array2d<unsigned char>();
}

void dlib_array2d_del(array2d<unsigned char>* p_array2d) {
    delete p_array2d;
}

void dlib_load_image(array2d<unsigned char>* img, char* argv) {
    load_image(*img, argv);
}

void dlib_pyramid_up(array2d<unsigned char>* img) {
    pyramid_up(*img);
}

std::vector<dlib::rectangle>* dlib_detector_dets(frontal_face_detector* detector, dlib::array2d<unsigned char>* img) {
    return new std::vector<dlib::rectangle>(std::move((*detector)(*img)));
}

void dlib_detector_dets_del(std::vector<dlib::rectangle>* p_dets) {
    delete p_dets;
}

int dlib_dector_dets_size(std::vector<dlib::rectangle>* p_dets) {
    return p_dets->size();
}

void dlib_image_window_clear_overlay(dlib::image_window* win) {
    win->clear_overlay();
}

void dlib_image_window_set_image(dlib::image_window* win, dlib::array2d<unsigned char>* img) {
    win->set_image((*img));
}

void dlib_image_window_add_overlay(dlib::image_window* win, std::vector<dlib::rectangle>* dets, dlib::rgb_pixel* p_rgb) {
    win->add_overlay((*dets), (*p_rgb));
}

dlib::rgb_pixel* dlib_rgb_pixel(int r, int g, int b) {
    return new dlib::rgb_pixel(r, g, b);
}

void dlib_rgb_pixel_del(dlib::rgb_pixel* p_rgb_pixel) {
    delete p_rgb_pixel;
}
