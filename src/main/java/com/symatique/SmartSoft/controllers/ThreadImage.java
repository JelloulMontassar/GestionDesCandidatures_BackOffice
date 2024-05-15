package com.symatique.SmartSoft.controllers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ThreadImage extends Thread implements Runnable {

//	private List<String> listPhotos = new ArrayList<>();
//    private List<String> listImagesBase64 = new ArrayList<>();
//    private String path = null;
//
//    public ThreadImage(List<String> listPhotos, List<String> listImagesBase64, String path) {
//        this.listPhotos = listPhotos;
//        this.listImagesBase64 = listImagesBase64;
//        this.path = path;
//        this.start();
//    }
//
//    @Override
//    public void run() {
//        int i = 0;
//        if (listPhotos != null && !listPhotos.isEmpty()) {
//            while (i < listPhotos.size()) {
//                try {
//                    try {
//                        BASE64Decoder decoder = new BASE64Decoder();
//                        byte[] decodedBytes = decoder.decodeBuffer(listImagesBase64.get(i));
//                        InputStream img = new ByteArrayInputStream(decodedBytes);
//                        boolean res = FileUploadController.uploderFichier(listPhotos.get(i), img, path);
//                    } catch (Exception e) {
//                        System.out.println("ThreadCreationPhoto ERREUR PHOTO : " + e.getMessage());
//                    }
//                    ThreadCreationPhoto.sleep(2000);
//                } catch (InterruptedException ex) {
//                    System.out.println("==> ThreadCreationPhoto InterruptedException : " + ex.getMessage());
//                }
//                i++;
//            }
//        }
//    }
//	
	
}