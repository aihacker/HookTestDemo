#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_xiaojianbang_app_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT int JNICALL
Java_com_xiaojianbang_app_NativeHelper_add(
        JNIEnv* env,
        jclass clazz, int intValue1,int intValue2, int intValue3) {
    int sum = intValue1+ intValue2 + intValue3;
    return sum;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_xiaojianbang_app_NativeHelper_encode(
        JNIEnv* env,
        jclass clazz, jstring str) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_xiaojianbang_app_NativeHelper_helloFromC(
        JNIEnv* env,
        jclass clazz) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
