package com.nameisjayant.composepractise.accessbility

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription


/*
      - any component size will be at least 48.dp size
      - provide description to the image
      - provide description to clickable content

 */

/*
      Semantic
      - it make a separate semantic tree
      - the clickable and toggleable modifiers will automatically merge their descendants
 */

@Composable
fun Accessibility(modifier: Modifier = Modifier) {
    var selected by remember {
        mutableStateOf(false)
    }

    // provide label to any action
    Box(
        modifier = Modifier.semantics {
            onClick(label = "click", action = {
                //action
                false
            })
        }
    ) {

    }

    // heading semantic
    Text(
        text = "Heading Text", style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.semantics { heading() }
    )

    // change state description

    Row(
        modifier = Modifier.toggleable(
            value = selected,
            onValueChange = { selected = it },
            role = Role.Checkbox
        ).semantics{
            stateDescription = if(selected) "selected" else "not selected"

        }
    ) {
        Text(text = "CheckBox", modifier = Modifier.weight(1f))
        Checkbox(checked = selected, onCheckedChange = null)

    }

}