//
//  ContentView.swift
//  iosApp
//
//  Created by Vivien Mahé on 12/01/2025.
//

import SwiftUI
import composeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.all)
    }
}
