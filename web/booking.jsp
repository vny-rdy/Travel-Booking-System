<!DOCTYPE html>
<html>
<head>
    <title>Booking</title>
</head>
<body>
    <h2>Book a Trip</h2>
    <form action="booking" method="post">
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination"><br>
        <label for="departure_date">Departure Date:</label>
        <input type="date" id="departure_date" name="departure_date"><br>
        <label for="return_date">Return Date:</label>
        <input type="date" id="return_date" name="return_date"><br>
        <input type="submit" value="Book">
    </form>
    <p>${param.error}</p>
</body>
</html>
