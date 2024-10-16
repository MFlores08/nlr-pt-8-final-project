const allRecipes = [
  // add objects to represent your custom application resources here
  {
    collectionId: 10,
    ingredients: "2 cups milk, 1 1/3 cups hot freshly brewed dark roast espresso coffee",
    directions: "Gather the ingredients. Heat milk in a saucepan set over medium-low heat. Whisk briskly with a wire whisk to create foam. Brew espresso and pour into four cups. Pour in milk, holding back the foam with a spoon. Spoon foam over the top.",
    name: "Cafe Latte",
    id: 1
},
{
    collectionId: 11,
    ingredients: "2 tablespoons finely ground dark roast coffee, 4 ounces water, 4 ounces milk",
    directions: "Gather the ingredients. Place the water into the boiler of your espresso machine. Place the 2 tablespoons (2 shots) of ground coffee into the portafilter. Tamp (press) the coffee down using a tamper. Do this 2 to 3 times to make sure the grounds are packed tightly. Place the portafilter into your espresso machine's group head and lock it in place by turning it to the right. Place a demitasse cup or the glass carafe that came with your espresso machine under the group head and pull the shot for 23 to 30 seconds, or until 2 ounces of espresso is yielded. Typically, there is a lever, switch, or button to start this process. Once the shot is pulled, foam the milk. Place the milk into either a glass measuring cup or a small metal pitcher. Insert the steam wand into the container with the milk, just under the surface of the milk. Engage the steam wand on your espresso machine. (You may need to read your espresso machine's manual for this, as each espresso maker is a little different.) Make sure to keep the tip of the wand toward the side of the container. This will create a vortex with the milk. Move the container higher, lower, closer, then further so that the steam wand can incorporate the air into the milk, making the foam. The bubbles should get smaller and smaller as you do this. Once the milk has foamed to double its size, turn the steam wand off. Top the espresso with foamed milk right after foaming. When initially poured, cappuccino is only espresso and foam, but the liquid milk quickly settles out of the foam to create the (roughly) equal parts foam, steamed milk, and espresso for which cappuccino is known.",
    name: "Cappuccino",
    id: 2
},
{
    collectionId: 12,
    ingredients: "12 oz reduced fat or whole milk or other kind of plant milk, 2 tbsp vanilla syrup, 2 oz espresso, caramel sauce to drizzle",
    directions: "Gather the ingredients. Prepare the espresso using a macchinetta or espresso machine. (You may use a very strong coffee, but you'll need to double the amount: use 4 oz instead of 2). While the espresso is being made, warm up the milk. Froth the milk using a milk frother. If you don't have a milk frother, you can use a regular whisk instead. (Just whisk the milk until foam forms). If you have an espresso machine at home, use the steam option to warm up and froth the milk. Pour the espresso into a measuring cup. Add vanilla and frothed milk to the cup. Then, pour the espresso on top of the frothy milk creating a \"mark\" on the foam. (Macchiato means \"marked\" in Italian). And the last step is to drizzle the caramel on top. At Starbucks, we make two circles around the edges of the cup and then we make a grate pattern in the middle. Some people like to add a drizzle of caramel to the bottom of the cup as well.",
    name: "Copycat Starbucks Caramel Macchiato",
    id: 3
},
{
    collectionId: 13,
    ingredients: "1 cup milk, ½ cup cold brewed coffee, 2 (1 gram) packets granular sucralose sweetener (such as Splenda®)",
    directions: "Mix milk, coffee, and sweetener together in a glass until sweetener is dissolved.",
    name: "Simple Coffee Drink",
    id: 4
},
{
    collectionId: 13,
    ingredients: "water, instant coffee",
    directions: "Add 1 tbsp of instant coffee to 8 oz water. Add ice.",
    name: "Iced Coffee",
    id: 6
}

];

const allCollections = [
  {
    name: "Lattes",
    id: 10
},
{
    name: "Cappuccinos",
    id: 11
},
{
    name: "Macchiatos",
    id: 12
},
{
    name: "Just Coffee",
    id: 13
}
];

const collectionId10 = [
  {
    collectionId: 10,
    ingredients: "2 cups milk, 1 1/3 cups hot freshly brewed dark roast espresso coffee",
    directions: "Gather the ingredients. Heat milk in a saucepan set over medium-low heat. Whisk briskly with a wire whisk to create foam. Brew espresso and pour into four cups. Pour in milk, holding back the foam with a spoon. Spoon foam over the top.",
    name: "Cafe Latte",
    id: 1
  }
];

const collectionId11 = [
  {
    collectionId: 11,
    ingredients: "2 tablespoons finely ground dark roast coffee, 4 ounces water, 4 ounces milk",
    directions: "Gather the ingredients. Place the water into the boiler of your espresso machine. Place the 2 tablespoons (2 shots) of ground coffee into the portafilter. Tamp (press) the coffee down using a tamper. Do this 2 to 3 times to make sure the grounds are packed tightly. Place the portafilter into your espresso machine's group head and lock it in place by turning it to the right. Place a demitasse cup or the glass carafe that came with your espresso machine under the group head and pull the shot for 23 to 30 seconds, or until 2 ounces of espresso is yielded. Typically, there is a lever, switch, or button to start this process. Once the shot is pulled, foam the milk. Place the milk into either a glass measuring cup or a small metal pitcher. Insert the steam wand into the container with the milk, just under the surface of the milk. Engage the steam wand on your espresso machine. (You may need to read your espresso machine's manual for this, as each espresso maker is a little different.) Make sure to keep the tip of the wand toward the side of the container. This will create a vortex with the milk. Move the container higher, lower, closer, then further so that the steam wand can incorporate the air into the milk, making the foam. The bubbles should get smaller and smaller as you do this. Once the milk has foamed to double its size, turn the steam wand off. Top the espresso with foamed milk right after foaming. When initially poured, cappuccino is only espresso and foam, but the liquid milk quickly settles out of the foam to create the (roughly) equal parts foam, steamed milk, and espresso for which cappuccino is known.",
    name: "Cappuccino",
    id: 2
  }
];

const collectionId12 = [
  {
    collectionId: 12,
    ingredients: "12 oz reduced fat or whole milk or other kind of plant milk, 2 tbsp vanilla syrup, 2 oz espresso, caramel sauce to drizzle",
    directions: "Gather the ingredients. Prepare the espresso using a macchinetta or espresso machine. (You may use a very strong coffee, but you'll need to double the amount: use 4 oz instead of 2). While the espresso is being made, warm up the milk. Froth the milk using a milk frother. If you don't have a milk frother, you can use a regular whisk instead. (Just whisk the milk until foam forms). If you have an espresso machine at home, use the steam option to warm up and froth the milk. Pour the espresso into a measuring cup. Add vanilla and frothed milk to the cup. Then, pour the espresso on top of the frothy milk creating a \"mark\" on the foam. (Macchiato means \"marked\" in Italian). And the last step is to drizzle the caramel on top. At Starbucks, we make two circles around the edges of the cup and then we make a grate pattern in the middle. Some people like to add a drizzle of caramel to the bottom of the cup as well.",
    name: "Copycat Starbucks Caramel Macchiato",
    id: 3
  }
]

const collectionId13 = [
  {
    collectionId: 13,
    ingredients: "1 cup milk, ½ cup cold brewed coffee, 2 (1 gram) packets granular sucralose sweetener (such as Splenda®)",
    directions: "Mix milk, coffee, and sweetener together in a glass until sweetener is dissolved.",
    name: "Simple Coffee Drink",
    id: 4
  },
  {
    collectionId: 13,
    ingredients: "water, instant coffee",
    directions: "Add 1 tbsp of instant coffee to 8 oz water. Add ice.",
    name: "Iced Coffee",
    id: 6
  }
];

const resourceService = {
  getRecipes() {
    return allRecipes;
  },
  getCollections() {
    return allCollections;
  },
  getRecipeById(collectionId) {
    switch (collectionId) {
      case 10:
        return collectionId10;
      case 11:
        return collectionId11;
      case 12:
        return collectionId12;
      case 13:
        return collectionId13;
      default:
        return [];
    }
  }
};

export { resourceService };
