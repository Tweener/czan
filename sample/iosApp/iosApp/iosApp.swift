//
//  iosAppApp.swift
//  iosApp
//
//  Created by Vivien Mahé on 12/01/2025.
//

import SwiftUI

@main
struct iosApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
