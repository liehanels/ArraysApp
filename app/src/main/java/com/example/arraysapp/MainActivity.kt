package com.example.arraysapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Must be 'var' so we can reassign it to a new array when adding items.
    private var inventory = arrayOf("Sweetroll", "Lockpick", "Soul Gem", "Skooma", "Iron Sword")

    // Declare the TextView at the class level so our helper function can see it
    private lateinit var tvInventory: TextView
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Grabbing our UI elements
        tvInventory = findViewById(R.id.tvInventory)
        val etAddItem = findViewById<EditText>(R.id.etAddItem)
        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val etSearch = findViewById<EditText>(R.id.etSearch)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        tvResult = findViewById<TextView>(R.id.tvResult)

        // 1. Initial display of the array
        updateInventoryDisplay()

        // 2. The Add Button Click Listener
        btnAddItem.setOnClickListener {
            val newItem = etAddItem.text.toString().trim()

            if (newItem.isNotEmpty()) {
                // The '+=' operator on an Array creates a brand-new array under the hood,
                // copies the old shit, adds the new item, and reassigns the variable.
                inventory += newItem

                updateInventoryDisplay() // Refresh the screen
                etAddItem.text.clear()   // Clear the input field
                tvResult.text = "Added '$newItem' to your pack."
            } else {
                tvResult.text = "You can't add nothing to your inventory!"
            }
        }

        // 3. The Search Button Click Listener
        btnSearch.setOnClickListener {
            val searchTarget = etSearch.text.toString().trim()//get the value

            searchItem(searchTarget)
        }

        btnDelete.setOnClickListener {
            val deleteTarget = etSearch.text.toString().trim()

            var index = searchItem(deleteTarget)

            if(index == -1)
            {
                return@setOnClickListener
            }
            else if (index < inventory.size)
            {
                //creating ia new filtered array, filtering the old array by removing the value we don't want, and converting the answer to the filtered array
                var filteredArray = inventory.filter { it != inventory[index] }.toTypedArray()
                inventory = filteredArray
                updateInventoryDisplay()
            }
        }
    }//override fun onCreate

    // A helper function to loop through the array and update the TextView.
    // Saves us from writing this exact same loop multiple times.
    private fun updateInventoryDisplay() {
        var displayString = "Current Inventory:\n"
        for (item in inventory) {
            displayString += "-> $item\n"
        }
        tvInventory.text = displayString
    }
    //private (accessor)
    // fun (function)
    // searchItem (function name)
    // (search: String) (PARAMETERS - variable INSIDE of the function + it's variable type)
    // : Int (the return type of the function)
    private fun searchItem(search: String): Int {
        var isFound = false
        var index = -1

        if (search.isEmpty()) {
            tvResult.text = "Don't search for empty air, type some stuff in!"
            return -1
        }

        // Looping to search for the value
        //inventory[0] = First record invetory[1] = Second record ...
        for (i in inventory.indices) {
            if (inventory[i].equals(search, ignoreCase = true)) {
                isFound = true
                index = i
                break
            }
        }

        // Displaying the final result
        if (isFound) {
            tvResult.text = "Success! Found '$search' at position ${index + 1}."
            return index
        } else {
            tvResult.text = "Item not found. You are over-encumbered with disappointment."
            return -1
        }
    }
}//class MainActivity