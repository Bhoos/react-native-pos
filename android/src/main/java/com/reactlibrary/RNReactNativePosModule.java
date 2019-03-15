
package com.reactlibrary;

import android.text.Layout;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.zcs.sdk.DriverManager;
import com.zcs.sdk.Printer;
import com.zcs.sdk.SdkResult;
import com.zcs.sdk.print.PrnStrFormat;
import com.zcs.sdk.print.PrnTextFont;

public class RNReactNativePosModule extends ReactContextBaseJavaModule {
  private final ReactApplicationContext reactContext;

  private Printer printer;
  private PrnStrFormat defaultFormat;

  public RNReactNativePosModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    printer = DriverManager.getInstance().getPrinter();

    defaultFormat = new PrnStrFormat();
    defaultFormat.setTextSize(24);
  }

  @Override
  public String getName() {
    return "RNReactNativePos";
  }


  @ReactMethod
  public void getPrinterStatus(Promise res) {
    // For checking out of paper printer status
    res.resolve(printer.getPrinterStatus());
  }

  @ReactMethod
  public void setNormalFont() {
    defaultFormat.setFont(PrnTextFont.DEFAULT);
  }

  @ReactMethod
  public void setFontSize(int size) {
    defaultFormat.setTextSize(size);
  }

  @ReactMethod
  public void setBoldFont() {
    defaultFormat.setFont((PrnTextFont.SERIF));
  }

  @ReactMethod
  public void setLeftAlign() {
    defaultFormat.setAli(Layout.Alignment.ALIGN_LEFT);
  }

  @ReactMethod
  public void setRightAlign() {
    defaultFormat.setAli(Layout.Alignment.ALIGN_RIGHT);
  }

  @ReactMethod
  public void setCenterAlign() {
    defaultFormat.setAli(Layout.Alignment.ALIGN_CENTER);
  }

  @ReactMethod
  public void addQRCode(String content, int width, int height) {
    printer.setPrintAppendQRCode(content, width, height, Layout.Alignment.ALIGN_CENTER);
  }

  @ReactMethod
  public void addText(String text) {
    printer.setPrintAppendString(text, defaultFormat);
  }


  @ReactMethod
  public void print(Promise res) {
    setFontSize(24);
    addText(" ");
    addText(" ");
    int status = printer.setPrintStart();
    res.resolve(status != SdkResult.SDK_OK);
  }
}