package com.fiz.e_learn

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.util.*


//
//@Composable
//fun ELearnNavHost(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    NavHost(
//        navController = navController,
//        startDestination = ELearnScreen.Overview.name,
//        modifier = modifier
//    ) {
//        composable(ELearnScreen.Accounts.name) {
//            AccountsBody { name ->
//                navController.navigate("Accounts/${name}")
//            }
//        }
//        composable(ELearnScreen.Overview.name) {
//            OverviewBody(
//                onClickSeeAllAccounts = { navController.navigate(ELearnScreen.Accounts.name) },
//                onClickSeeAllBills = { navController.navigate(ELearnScreen.Bills.name) },
//                onAccountClick = { name ->
//                    navController.navigate("${ELearnScreen.Accounts.name}/$name")
//                },
//            )
//        }
//        composable(ELearnScreen.Accounts.name) {
//            AccountsBody { name ->
//                navController.navigate("Accounts/${name}")
//            }
//        }
//        composable(ELearnScreen.Bills.name) {
//            BillsBody()
//        }
//        val accountsName = ELearnScreen.Accounts.name
//        composable(
//            "$accountsName/{name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                },
//            ),
//        ) { entry ->
//            val accountName = entry.arguments?.getString("name")
////            val account = UserData.getAccount(accountName)
//            SingleAccountBody()
//        }
//    }
//}

//private fun navigateToSingleAccount(
//    navController: NavHostController,
//    accountName: String
//) {
//    navController.navigate("${ELearnScreen.Accounts.name}/$accountName")
//}


@Composable
fun AccountsBody(onAccountClick: (String) -> Unit = {},) {

}

@Composable
fun SingleAccountBody(onAccountClick: (String) -> Unit = {},) {

}

@Composable
fun OverviewBody(
    onClickSeeAllAccounts: () -> Unit = {},
    onClickSeeAllBills: () -> Unit = {},
    onAccountClick: (String) -> Unit = {},
) {
    Column {
        Button(onClick = { onClickSeeAllAccounts() }) {
            Text(text = "callBack1")
        }
        Button(onClick = { onClickSeeAllBills() }) {
            Text(text = "callBack2")
        }
        Button(onClick = { onAccountClick("123") }) {
            Text(text = "callBack3")
        }
    }
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .verticalScroll(rememberScrollState())
//                .semantics { contentDescription = "Overview Screen" }
//        ) {
//            AlertCard()
//            Spacer(Modifier.height(RallyDefaultPadding))
//            AccountsCard(onClickSeeAllAccounts, onAccountClick = onAccountClick)
//            Spacer(Modifier.height(RallyDefaultPadding))
//            BillsCard(onClickSeeAllBills)
//        }
}


@Composable
fun BillsBody() {

}




@Composable
fun FloatingActionButton(
    backgroundColor: Color = MaterialTheme.colors.secondary,
) {
}

@Composable
private fun MainActivityScreen(mainViewModel: MainViewModel) {
    MainScreen(
        items = mainViewModel.mainItems,
        onAddItem = { mainViewModel.addItem(it) }, // in the next steps we'll complete this
        onRemoveItem = { mainViewModel.removeItem(it) } // in the next steps we'll complete this
    )
}

@Composable
private fun MainScreen(
    items: MainItems,
    onAddItem: (MainItems) -> Unit,
    onRemoveItem: (MainItems) -> Unit
) {
    Column {
        Text(text = items.toString())
        Button(onClick = { onAddItem(MainItems(0)) }) {
            Text(text = "Add")
        }
        Button(onClick = { onRemoveItem(MainItems(0)) }) {
            Text(text = "Remove")
        }
    }
}

data class MainItems(val page: Int = 0)

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Composable
//private fun MyApp() {
//    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//
//    if (shouldShowOnboarding) {
//        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
//    } else {
//        Greetings()
//    }
//}

@Composable
private fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = { /* Ignoring onClick */ })
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}


@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    heightDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Composable
//fun LayoutsCodelabPreview() {
//    ELearnTheme {
//        LazyList()
//    }
//}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}
//
//@Composable
//fun TodoItemInput(onItemComplete: (TodoItem) -> Unit) {
//    val (text, setText) = remember { mutableStateOf("") }
//    val (icon, setIcon) = remember { mutableStateOf(TodoIcon.Default)}
//    val iconsVisible = text.isNotBlank()
//    val submit = {
//        onItemComplete(TodoItem(text, icon))
//        setIcon(TodoIcon.Default)
//        setText("")
//    }
//    Column {
//        Row(Modifier
//            .padding(horizontal = 16.dp)
//            .padding(top = 16.dp)
//        ) {
//            TodoInputText(
//                text = text,
//                onTextChange = setText,
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(end = 8.dp),
//                onImeAction = submit // pass the submit callback to TodoInputText
//            )
//            TodoEditButton(
//                onClick = submit, // pass the submit callback to TodoEditButton
//                text = "Add",
//                modifier = Modifier.align(Alignment.CenterVertically),
//                enabled = text.isNotBlank()
//            )
//        }
//        if (iconsVisible) {
//            AnimatedIconRow(icon, setIcon, Modifier.padding(top = 8.dp))
//        } else {
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInputText(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        modifier = modifier
    )
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

//@Composable
//fun ImageListItem(index: Int) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//
//        Image(
//            painter = rememberImagePainter(
//                data = "https://developer.android.com/images/brand/Android_Robot.png"
//            ),
//            contentDescription = "Android Logo",
//            modifier = Modifier.size(50.dp)
//        )
//        Spacer(Modifier.width(10.dp))
//        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
//    }
//}