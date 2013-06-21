
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void shouldBeDegradatedOneUnitInOneItem() {
        parametricTestCase("foo", 1, 1, 0, 0);
    }

   // @Test
    public void   shouldBeNotUpdateItemWithQualityofSixty(){
        parametricTestCase("foo", 1, 60, 0, 59);
    }

    @Test
    public void deberiaMantenerLaCalidadEnCero(){
        parametricTestCase("foo", 1, 0, 0, 0);
    }


    @Test
    public void siElDiaDeVentaLlegaLaDegradacionSeDuplica(){
        parametricTestCase("foo", 0, 30, -1, 28);
    }


    @Test
    public void AgedBrieIncreasesQuality(){
        parametricTestCase("Aged Brie", 10, 30, 9, 31);
    }

    @Test
    public void qualityIsNeverGreaterThan50(){
        parametricTestCase("Aged Brie", 10, 50, 9, 50);
    }

    @Test
    public void agedBrieIncrementaSuCalidadDespuesDeLafechaDeVenta(){
        parametricTestCase("Aged Brie", -1, 48, -2, 50);
    }

    @Test
    public void sulfurasNoDebeDegradarseNiModificarLosDias(){
        parametricTestCase("Sulfuras, Hand of Ragnaros", 10, 80, 10, 80);
    }

    @Test
    public void backstagePassesIncreasesQuality(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 12, 30, 11, 31);
    }

    @Test
    public void backstagePassesIncreasesQualityByOneInWithSellInIs11(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 11, 30, 10, 31);
    }

    @Test
    public void backstagePassesIncreasesByTwoWhenSellInIsTenOrLess(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 10, 30, 9, 32);
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 9, 30, 8, 32);
    }

    @Test
    public void backstagePassesIncreasesBy3WhenSellInIs5OrLess(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 5, 30, 4, 33);
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 4, 30, 3, 33);
    }

    @Test
    public void backstagePassesIncreasesBy2WhenSellInIs6(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 6, 30, 5, 32);
    }

    @Test
    public void backstagePassesReduceSuCalidadCuandoLlegaEldiaFinal(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 0, 10, -1, 0);
    }

    @Test
    public void backstagePassesIncreasesBy3WhenSellInIsOne(){
        parametricTestCase("Backstage passes to a TAFKAL80ETC concert", 1, 10, 0, 13);
    }

    @Test
    public void multipleItemsWorkSuccessfully(){
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Item[] itemsOutput = new Item[] { new Item("+5 Dexterity Vest", 9, 19),
                new Item("Aged Brie", 1, 1),
                new Item("Elixir of the Mongoose", 4, 6),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                new Item("Conjured Mana Cake", 2, 5) };

        for (int i = 0; i < itemsOutput.length; i++) {
            assertEquals("validating name",itemsOutput[i].name, app.items[i].name);
            assertEquals("validating quality",itemsOutput[i].quality, app.items[i].quality);
            assertEquals("validating sellin", itemsOutput[i].sellIn, app.items[i].sellIn);
        }


    }

    private void parametricTestCase(String itemName, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality){
        Item[] items = new Item[] { new Item(itemName, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        assertEquals("validating name",itemName, app.items[0].name);
        assertEquals("validating quality",expectedQuality, app.items[0].quality);
        assertEquals("validating sellin",expectedSellIn, app.items[0].sellIn);
    }

}
