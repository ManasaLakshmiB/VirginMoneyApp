import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.virginMoneyapp.data.model.people.PeopleItemModel
import com.example.virginMoneyapp.ui.viewmodel.PeopleViewModel


@Composable
fun PeopleList(viewModel: PeopleViewModel, navController: NavController) {


    val people by viewModel.liveData.observeAsState()

    LazyColumn {
        items(people.orEmpty()) { person ->
            ContactCard(person, navController)
        }
    }
}

@Composable
fun ContactCard(person: PeopleItemModel, navController: NavController) {

    Log.d("ContactList", "Rendering person: ${person.firstName}")

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { navController.navigate("detail/${person.id}") },
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = person.avatar,
                contentDescription = "person Image",
                modifier = Modifier
                    .padding(15.dp)
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Text(text = person.firstName ?: "no name here", fontSize = 24.sp)
            Spacer(
                modifier = Modifier
                    .padding(2.dp)
            )
            Text(text = person.lastName ?: "no name here", fontSize = 24.sp)
        }
    }
}



