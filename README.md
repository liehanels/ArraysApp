# 🎒 RPG Loot Manager (Array & Iteration Demo)

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)

> A lightweight Android application built to demonstrate the fundamental behaviours of fixed-size arrays, iteration, and basic linear search algorithms, wrapped in an Elder Scrolls-inspired inventory interface.

## 📖 Overview
This project is an educational demonstration designed to bridge the gap between back-end data structures and front-end UI updates. Instead of just printing array outputs to a boring terminal, this app dynamically renders a player's inventory to the screen, allows them to add new loot (demonstrating memory reallocation), and searches through the items using a manual loop.

## ✨ Key Features
* **Dynamic Inventory Display:** Iterates through a Kotlin `Array<String>` and renders the contents to a `TextView`.
* **Add Loot Mechanism:** Demonstrates how arrays handle size constraints by creating a new, larger array under the hood when the user adds an item.
* **Linear Search:** Implements a manual `for` loop search to find specific items, showcasing early algorithm design before abstracting to built-in functions.
* **Responsive UI:** Utilises `ConstraintLayout` to ensure the app scales perfectly across different device screens without looking like absolute crap.

## 🛠️ Tech Stack
* **Language:** Kotlin
* **IDE:** Android Studio
* **Layout:** `ConstraintLayout` (XML)
* **Minimum SDK:** API 24 (Nougat)
