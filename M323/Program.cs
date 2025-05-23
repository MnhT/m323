 class Program
{
    static void Main()
    {
        // Aufgabe 1
        Console.WriteLine(CalculateScore("imperative")); // 9
        Console.WriteLine(CalculateScore("no"));         // 2
        Console.WriteLine(WordScore("declarative"));     // 9
        Console.WriteLine(WordScore("yes"));             // 3

        // Aufgabe 2 - Imperativ
        var cart = new ShoppingCart();
        cart.AddItem("pen");
        cart.AddItem("book: C# Basics");
        Console.WriteLine(cart.GetDiscountPercentage()); // 5.0
        cart.RemoveItem("book: C# Basics");
        Console.WriteLine(cart.GetDiscountPercentage()); // 0.0

        // Aufgabe 2 - Funktional
        var items = new List<string> { "pen", "book: LINQ" };
        Console.WriteLine(FunctionalCart.GetDiscountPercentage(items)); // 5.0

        // Aufgabe 3 - Pure Function
        var group = new List<string> { "Alice", "Bob", "Charlie" };
        Console.WriteLine(TipCalculator.GetTipPercentage(group)); // 10
    }

    // Aufgabe 1 - Imperativ
    public static int CalculateScore(string word)
    {
        int score = 0;
        foreach (char c in word)
        {
            if (c != 'a')
                score++;
        }
        return score;
    }

    // Aufgabe 1 - Deklarativ
    public static int WordScore(string word)
    {
        return word.Count(c => c != 'a');
    }
}

// Aufgabe 2 - Imperativ
public class ShoppingCart
{
    private List<string> items = new List<string>();
    private bool bookAdded = false;

    public void AddItem(string item)
    {
        items.Add(item);
        if (item.ToLower().Contains("book"))
            bookAdded = true;
    }

    public void RemoveItem(string item)
    {
        items.Remove(item);
        bookAdded = items.Any(i => i.ToLower().Contains("book"));
    }

    public List<string> GetItems()
    {
        return items;
    }

    public double GetDiscountPercentage()
    {
        return bookAdded ? 5.0 : 0.0;
    }
}

// Aufgabe 2 - Funktional
public static class FunctionalCart
{
    public static double GetDiscountPercentage(List<string> items)
    {
        return items.Any(i => i.ToLower().Contains("book")) ? 5.0 : 0.0;
    }
}

// Aufgabe 3 - Pure Function
public static class TipCalculator
{
    public static int GetTipPercentage(List<string> names)
    {
        if (names == null || names.Count == 0)
            return 0;
        return names.Count > 5 ? 20 : 10;
    }
}
