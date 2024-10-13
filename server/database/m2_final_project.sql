-- database m2_final_project
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS users, collections, coffee_recipes, nutrition_info CASCADE;
DROP SEQUENCE IF EXISTS recipe_serial, collection_serial, nutrition_serial CASCADE;
-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

--users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE collection_serial;
CREATE TABLE collections(
	collection_id int NOT NULL DEFAULT nextval ('collection_serial'),
	collection_name char(50) NOT NULL,
	CONSTRAINT PK_collections PRIMARY KEY(collection_id)
);

CREATE SEQUENCE recipe_serial;
CREATE TABLE coffee_recipes(
	recipe_id int NOT NULL DEFAULT nextval ('recipe_serial'),
	recipe_name char(50) NOT NULL,
	collection_id int NOT NULL,
	ingredients varchar(200) NULL,
	directions varchar (2000) NULL,
	CONSTRAINT PK_recipes PRIMARY KEY(recipe_id),
	CONSTRAINT FK_coffee_recipes_collections FOREIGN KEY(collection_id) REFERENCES collections(collection_id)
);

CREATE SEQUENCE nutrition_serial;
CREATE TABLE nutrition_info(
	nutrition_id int NOT NULL DEFAULT nextval ('nutrition_serial'),
	recipe_id int NOT NULL,
	sugar_content varchar(10) NULL,
    sodium_content varchar(10) NULL,
    caffeine_content varchar(10) NULL,
	CONSTRAINT PK_nutrition_info PRIMARY KEY(nutrition_id),
	CONSTRAINT FK_nutrition_info_coffee_recipes FOREIGN KEY(recipe_id) REFERENCES coffee_recipes(recipe_id)
);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************

-- Users
-- Password for all users is password
INSERT INTO
    users (username, password_hash, role)
VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN');

INSERT INTO
    collections(collection_id, collection_name)
VALUES
    (10, 'latte'),
    (11, 'cappuccino'),
    (12, 'macchiato'),
    (13, 'just coffee');

INSERT INTO
    coffee_recipes(recipe_id, recipe_name, collection_id, ingredients, directions)
VALUES
    (1, 'Cafe Latte', '10', '2 cups milk, 1 1/3 cups hot freshly brewed dark roast espresso coffee', 'Gather the ingredients. Heat milk in a saucepan set over medium-low heat. Whisk briskly with a wire whisk to create foam. Brew espresso and pour into four cups. Pour in milk, holding back the foam with a spoon. Spoon foam over the top.'),
    (2, 'Cappuccino', '11', '2 tablespoons finely ground dark roast coffee, 4 ounces water, 4 ounces milk', 'Gather the ingredients. Place the water into the boiler of your espresso machine. Place the 2 tablespoons (2 shots) of ground coffee into the portafilter. Tamp (press) the coffee down using a tamper. Do this 2 to 3 times to make sure the grounds are packed tightly. Place the portafilter into your espresso machine''s group head and lock it in place by turning it to the right. Place a demitasse cup or the glass carafe that came with your espresso machine under the group head and pull the shot for 23 to 30 seconds, or until 2 ounces of espresso is yielded. Typically, there is a lever, switch, or button to start this process. Once the shot is pulled, foam the milk. Place the milk into either a glass measuring cup or a small metal pitcher. Insert the steam wand into the container with the milk, just under the surface of the milk.Engage the steam wand on your espresso machine. (You may need to read your espresso machine''s manual for this, as each espresso maker is a little different.) Make sure to keep the tip of the wand toward the side of the container. This will create a vortex with the milk. Move the container higher, lower, closer, then further so that the steam wand can incorporate the air into the milk, making the foam. The bubbles should get smaller and smaller as you do this. Once the milk has foamed to double its size, turn the steam wand off. Top the espresso with foamed milk right after foaming. When initially poured, cappuccino is only espresso and foam, but the liquid milk quickly settles out of the foam to create the (roughly) equal parts foam, steamed milk, and espresso for which cappuccino is known.'),
    (3, 'Copycat Starbucks Caramel Macchiato', '12', '12 oz reduced fat or whole milk or other kind of plant milk, 2 tbsp vanilla syrup, 2 oz espresso, caramel sauce to drizzle', 'Gather the ingredients. Prepare the espresso using a macchinetta or espresso machine. (You may use a very strong coffee, but you''ll need to double the amount: use 4 oz instead of 2). While the espresso is being made, warm up the milk. Froth the milk using a milk frother. If you don''t have a milk frother, you can use a regular whisk instead. (Just whisk the milk until foam forms). If you have an espresso machine at home, use the steam option to warm up and froth the milk. Pour the espresso into a measuring cup. Add vanilla and frothed milk to the cup. Then, pour the espresso on top of the frothy milk creating a "mark" on the foam. (Macchiato means "marked" in Italian). And the last step is to drizzle the caramel on top. At Starbucks, we make two circles around the edges of the cup and then we make a grate pattern in the middle. Some people like to add a drizzle of caramel to the bottom of the cup as well.'),
    (4, 'Simple Coffee Drink', '13', '1 cup milk, ½ cup cold brewed coffee, 2 (1 gram) packets granular sucralose sweetener (such as Splenda®)', 'Mix milk, coffee, and sweetener together in a glass until sweetener is dissolved.');

INSERT INTO
    nutrition_info(nutrition_id, recipe_id, sugar_content, sodium_content, caffeine_content)
VALUES
    (20, '1', '6', '61', '173'),
    (21, '2', '6', '62', '150'),
    (22, '3', '46', '199', '121'),
    (23, '4', '11', '102', '100');

COMMIT TRANSACTION;
