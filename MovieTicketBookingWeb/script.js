
// ==============================
// MOVIE DATA
// ==============================

const movies = [
    { name: "AVENGERS: ENDGAME", genre: "Action", image: "avengers.jpg", rating: 8.4, price: 570 },
    { name: "SPIDER-MAN", genre: "Action", image: "spiderman.jpg", rating: 8.2, price: 420 },
    { name: "DARK KNIGHT", genre: "Action", image: "darkknight.jpg", rating: 9.0, price: 550 },
    { name: "JOHN WICK", genre: "Action", image: "johnwick.jpg", rating: 7.4, price: 480 },
    { name: "TOP GUN: MAVERICK", genre: "Action", image: "topgun.jpg", rating: 8.2, price: 520 },
    { name: "INTERSTELLAR", genre: "Sci-Fi", image: "interstellar.jpg", rating: 8.7, price: 450 },
    { name: "AVATAR", genre: "Sci-Fi", image: "avatar.jpg", rating: 7.9, price: 500 },
    { name: "DUNE: PART TWO", genre: "Sci-Fi", image: "duneparttwo.jpg", rating: 8.5, price: 550 },
    { name: "THE MATRIX", genre: "Sci-Fi", image: "matrix.jpg", rating: 8.7, price: 450 },
    { name: "INCEPTION", genre: "Thriller", image: "inception.jpg", rating: 8.8, price: 600 },
    { name: "SHUTTER ISLAND", genre: "Thriller", image: "shutterisland.jpg", rating: 8.2, price: 430 },
    { name: "GONE GIRL", genre: "Thriller", image: "gonegirl.jpg", rating: 8.1, price: 420 },
    { name: "NOW YOU SEE ME", genre: "Thriller", image: "nowyouseeme.jpg", rating: 7.2, price: 400 },
    { name: "JUMANJI", genre: "Comedy", image: "jumanji.jpg", rating: 7.0, price: 380 },
    { name: "THE HANGOVER", genre: "Comedy", image: "hangover.jpg", rating: 7.7, price: 350 },
    { name: "HOME ALONE", genre: "Comedy", image: "homealone.jpg", rating: 7.7, price: 350 },
    { name: "TITANIC", genre: "Romance", image: "titanic.jpg", rating: 7.9, price: 450 },
    { name: "LA LA LAND", genre: "Romance", image: "lalaland.jpg", rating: 8.0, price: 400 },
    { name: "THE FAULT IN OUR STARS", genre: "Romance", image: "faultinstars.jpg", rating: 7.7, price: 380 },
    { name: "VOICEMAILS FOR ISABEL", genre: "Romance", image: "voicemailsforisabel.jpg", rating: 0, price: 400 },
    { name: "THE CONJURING", genre: "Horror", image: "conjuring.jpg", rating: 7.5, price: 420 },
    { name: "A QUIET PLACE", genre: "Horror", image: "quietplace.jpg", rating: 7.5, price: 400 },
    { name: "IT", genre: "Horror", image: "it.jpg", rating: 7.3, price: 380 },
    { name: "FROZEN", genre: "Animation", image: "frozen.jpg", rating: 7.4, price: 400 },
    { name: "THE LION KING", genre: "Animation", image: "lionking.jpg", rating: 8.5, price: 420 },
    { name: "COCO", genre: "Animation", image: "coco.jpg", rating: 8.4, price: 380 },
    { name: "INSIDE OUT 2", genre: "Animation", image: "insideout2.jpg", rating: 7.5, price: 400 },
    { name: "SPIDER-MAN: ACROSS THE SPIDER-VERSE", genre: "Animation", image: "spiderverse.jpg", rating: 8.6, price: 450 },
    { name: "JOKER", genre: "Drama", image: "joker.jpg", rating: 8.3, price: 460 },
    { name: "THE PURSUIT OF HAPPYNESS", genre: "Drama", image: "pursuitofhappyness.jpg", rating: 8.0, price: 380 }
];


// ==============================
// DOM ELEMENTS
// ==============================

const movieGrid = document.getElementById("movieGrid");
const searchInput = document.getElementById("searchInput");
const genreFilter = document.getElementById("genreFilter");

const bookingSection = document.getElementById("bookingSection");
const seatSection = document.getElementById("seatSection");
const snackSection = document.getElementById("snackSection");
const paymentSection = document.getElementById("paymentSection");
const confirmationSection = document.getElementById("confirmationSection");
const dashboardSection = document.getElementById("dashboardSection");

const selectedMovieLabel = document.getElementById("selectedMovie");
const bookingDate = document.getElementById("bookingDate");
const showTime = document.getElementById("showTime");

const seatLayout = document.getElementById("seatLayout");
const seatCount = document.getElementById("seatCount");
const seatTotal = document.getElementById("seatTotal");

const snackList = document.getElementById("snackList");


// ==============================
// GLOBAL VARIABLES
// ==============================

let selectedMovie = null;
let selectedSeats = [];
let currentSnacks = [];
let currentTotal = 0;
let snackQuantities = {};


// ==============================
// SNACK DATA
// ==============================

const snacks = [
    { name: "Popcorn", price: 150, image: "https://images.unsplash.com/photo-1578849278619-e73505e9610f?w=400" },
    { name: "Cheese Popcorn", price: 200, image: "https://images.unsplash.com/photo-1585647347483-22b66260dfff?w=400" },
    { name: "Nachos", price: 160, image: "https://images.unsplash.com/photo-1513456852971-30c0b8199d4d?w=400" },
    { name: "French Fries", price: 120, image: "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?w=400" },
    { name: "Burger", price: 180, image: "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=400" },
    { name: "Pizza", price: 250, image: "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=400" },
    { name: "Sandwich", price: 140, image: "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400" },
    { name: "Hotdog", price: 170, image: "https://images.unsplash.com/photo-1612392062126-2f9a7f0c0a5c?w=400" },
    { name: "Soft Drink", price: 100, image: "https://images.unsplash.com/photo-1513558161293-cdaf765edfd4?w=400" },
    { name: "Orange Juice", price: 120, image: "https://images.unsplash.com/photo-1600271886742-f049cd451bba?w=400" },
    { name: "Brownie", price: 130, image: "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?w=400" },
    { name: "Vanilla Ice Cream", price: 110, image: "https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=400" }
];


// ==============================
// LOCAL STORAGE
// ==============================

function getBookings() {
    try {
        const bookings = JSON.parse(localStorage.getItem("cinebookBookings"));
        return Array.isArray(bookings) ? bookings : [];
    } catch (error) {
        return [];
    }
}


// ==============================
// DISPLAY MOVIES
// ==============================

function displayMovies() {
    const searchValue = searchInput.value.toLowerCase();
    const selectedGenre = genreFilter.value;

    movieGrid.innerHTML = "";

    const filteredMovies = movies.filter(movie => {
        return movie.name.toLowerCase().includes(searchValue) &&
            (selectedGenre === "All" || movie.genre === selectedGenre);
    });

    filteredMovies.forEach(movie => {
        const movieCard = document.createElement("div");
        movieCard.className = "movie-card";

        movieCard.innerHTML = `
            <img src="posters/${movie.image}" alt="${movie.name}">
            <div class="movie-info">
                <h3>${movie.name}</h3>
                <p>${movie.genre}</p>
                <p>⭐ ${movie.rating ? movie.rating : "Not Rated"}</p>
                <p>₹${movie.price}</p>
                <button class="book-btn">Book Tickets</button>
            </div>
        `;

        movieCard.querySelector(".book-btn").addEventListener("click", function () {
            selectedMovie = movie;
            selectedSeats = [];
            currentSnacks = [];
            currentTotal = 0;

            selectedMovieLabel.textContent = movie.name;

            const today = new Date();
            const localToday = today.getFullYear() + "-" +
                String(today.getMonth() + 1).padStart(2, "0") + "-" +
                String(today.getDate()).padStart(2, "0");

            bookingDate.min = localToday;
            bookingDate.value = localToday;
            showTime.selectedIndex = 0;

            resetSnacks();
            hideAllSections();

            bookingSection.style.display = "block";
            bookingSection.scrollIntoView({ behavior: "smooth" });
        });

        movieGrid.appendChild(movieCard);
    });
}

searchInput.addEventListener("input", displayMovies);
genreFilter.addEventListener("change", displayMovies);


// ==============================
// HIDE ALL SECTIONS
// ==============================

function hideAllSections() {
    bookingSection.style.display = "none";
    seatSection.style.display = "none";
    snackSection.style.display = "none";
    paymentSection.style.display = "none";
    confirmationSection.style.display = "none";
    dashboardSection.style.display = "none";
}


// ==============================
// CONTINUE TO SEATS
// ==============================

document.getElementById("continueSeatsBtn").addEventListener("click", function () {
    if (!bookingDate.value) {
        alert("Please select a booking date!");
        return;
    }

    selectedSeats = [];

    document.getElementById("seatMovieName").textContent = selectedMovie.name;
    document.getElementById("seatBookingDate").textContent =
        "Booking Date: " + bookingDate.value;

    hideAllSections();
    seatSection.style.display = "block";

    createSeats();
    seatSection.scrollIntoView({ behavior: "smooth" });
});


// ==============================
// RANDOM DEMO BOOKED SEATS
// ==============================

function getDemoBookedSeats(movieIndex) {
    const demoSeats = [];

    while (demoSeats.length < 10) {
        const randomSeat = Math.floor(Math.random() * 40);

        if (!demoSeats.includes(randomSeat)) {
            demoSeats.push(randomSeat);
        }
    }

    return demoSeats;
}


// ==============================
// CREATE SEATS
// ==============================

function createSeats() {
    seatLayout.innerHTML = "";

    const date = bookingDate.value;
    const time = showTime.value;
    const bookings = getBookings();

    const savedBookedSeats = bookings
        .filter(booking =>
            booking.movie === selectedMovie.name &&
            booking.date === date &&
            booking.time === time
        )
        .flatMap(booking =>
            Array.isArray(booking.seats) ? booking.seats : []
        );

    const movieIndex = movies.indexOf(selectedMovie);
    const demoBookedSeats = getDemoBookedSeats(movieIndex);

    const rows = ["A", "B", "C", "D", "E"];

    rows.forEach(row => {
        for (let i = 1; i <= 8; i++) {
            const seatName = row + i;
            const seatNumber = (rows.indexOf(row) * 8) + (i - 1);

            const seat = document.createElement("button");
            seat.className = "seat";
            seat.textContent = seatName;

            if (
                demoBookedSeats.includes(seatNumber) ||
                savedBookedSeats.includes(seatName)
            ) {
                seat.classList.add("booked");
                seat.disabled = true;
            } else {
                seat.addEventListener("click", function () {
                    selectSeat(seat, seatName);
                });
            }

            seatLayout.appendChild(seat);
        }
    });

    updateSeatTotal();
}


// ==============================
// SELECT SEAT
// ==============================

function selectSeat(seat, seatName) {
    if (selectedSeats.includes(seatName)) {
        selectedSeats = selectedSeats.filter(s => s !== seatName);
        seat.classList.remove("selected");
    } else {
        selectedSeats.push(seatName);
        seat.classList.add("selected");
    }

    updateSeatTotal();
}


// ==============================
// UPDATE SEAT TOTAL
// ==============================

function updateSeatTotal() {
    seatCount.textContent = selectedSeats.length;
    seatTotal.textContent = "Total: ₹" +
        (selectedSeats.length * selectedMovie.price);
}


// ==============================
// CONTINUE TO SNACKS
// ==============================

document.getElementById("confirmSeatsBtn").addEventListener("click", function () {
    if (selectedSeats.length === 0) {
        alert("Please select at least one seat!");
        return;
    }

    hideAllSections();
    snackSection.style.display = "block";

    displaySnacks();
    calculateSnackTotal();

    snackSection.scrollIntoView({ behavior: "smooth" });
});


// ==============================
// DISPLAY SNACKS
// ==============================

function displaySnacks() {
    snackList.innerHTML = "";

    snacks.forEach((snack, index) => {
        const item = document.createElement("div");
        item.className = "snack-item";

        item.innerHTML = `
            <img src="${snack.image}" alt="${snack.name}">
            <h3>${snack.name}</h3>
            <p>₹${snack.price}</p>

            <div class="snack-quantity">
                <button class="minus-btn">-</button>
                <span class="quantity">0</span>
                <button class="plus-btn">+</button>
            </div>
        `;

        const quantityText = item.querySelector(".quantity");

        item.querySelector(".plus-btn").addEventListener("click", function () {
            snackQuantities[index] = (snackQuantities[index] || 0) + 1;
            quantityText.textContent = snackQuantities[index];
            calculateSnackTotal();
        });

        item.querySelector(".minus-btn").addEventListener("click", function () {
            if (snackQuantities[index] > 0) {
                snackQuantities[index]--;
                quantityText.textContent = snackQuantities[index];
                calculateSnackTotal();
            }
        });

        snackList.appendChild(item);
    });
}


// ==============================
// RESET SNACKS
// ==============================

function resetSnacks() {
    snackQuantities = {};
    currentSnacks = [];
    currentTotal = 0;

    if (snackList) {
        displaySnacks();
    }
}


// ==============================
// CALCULATE SNACK TOTAL
// ==============================

function calculateSnackTotal() {
    let snackTotal = 0;
    currentSnacks = [];

    snacks.forEach((snack, index) => {
        const quantity = snackQuantities[index] || 0;

        if (quantity > 0) {
            snackTotal += snack.price * quantity;

            currentSnacks.push({
                name: snack.name,
                quantity: quantity,
                price: snack.price
            });
        }
    });

    const ticketTotal = selectedSeats.length * selectedMovie.price;
    currentTotal = ticketTotal + snackTotal;

    document.getElementById("snackTotal").textContent =
        "Snacks Total: ₹" + snackTotal;

    document.getElementById("grandTotal").textContent =
        "Grand Total: ₹" + currentTotal;
}


// ==============================
// CONTINUE TO PAYMENT
// ==============================

document.getElementById("continuePaymentBtn").addEventListener("click", function () {
    hideAllSections();
    paymentSection.style.display = "block";

    document.getElementById("paymentMovie").textContent = selectedMovie.name;
    document.getElementById("paymentSeats").textContent = selectedSeats.join(", ");

    document.getElementById("paymentSnacks").textContent =
        currentSnacks.length > 0
            ? currentSnacks.map(s => s.name + " x" + s.quantity).join(", ")
            : "No snacks";

    document.getElementById("paymentTotal").textContent = "₹" + currentTotal;

    paymentSection.scrollIntoView({ behavior: "smooth" });
});


// ==============================
// DEMO PAYMENT
// ==============================

document.getElementById("payNowBtn").addEventListener("click", function () {
    const paymentMethod = document.getElementById("paymentMethod").value;

    const confirmDemo = confirm(
        "This is a demo booking. No real payment will be made.\n\nContinue?"
    );

    if (!confirmDemo) {
        return;
    }

    const date = bookingDate.value;
    const time = showTime.value;
    const bookings = getBookings();

    const alreadyBooked = bookings
        .filter(booking =>
            booking.movie === selectedMovie.name &&
            booking.date === date &&
            booking.time === time
        )
        .flatMap(booking =>
            Array.isArray(booking.seats) ? booking.seats : []
        );

    const conflict = selectedSeats.filter(seat =>
        alreadyBooked.includes(seat)
    );

    if (conflict.length > 0) {
        alert(
            "These seats have already been booked: " +
            conflict.join(", ") +
            "\nPlease select different seats."
        );

        selectedSeats = [];
        hideAllSections();
        seatSection.style.display = "block";
        createSeats();
        seatSection.scrollIntoView({ behavior: "smooth" });
        return;
    }

    const bookingId = "CB" + Date.now();

    const confirmedTicket = {
        bookingId: bookingId,
        movie: selectedMovie.name,
        date: date,
        time: time,
        seats: [...selectedSeats],
        snacks: [...currentSnacks],
        total: currentTotal,
        paymentMethod: paymentMethod
    };

    bookings.push(confirmedTicket);
    localStorage.setItem("cinebookBookings", JSON.stringify(bookings));

    showConfirmation(confirmedTicket);
});


// ==============================
// SHOW CONFIRMATION AND QR CODE
// ==============================

function showConfirmation(ticket) {
    hideAllSections();

    confirmationSection.style.display = "block";

    document.getElementById("ticketBookingId").textContent = ticket.bookingId;
    document.getElementById("ticketMovie").textContent = ticket.movie;
    document.getElementById("ticketDate").textContent = ticket.date;
    document.getElementById("ticketTime").textContent = ticket.time;
    document.getElementById("ticketSeats").textContent = ticket.seats.join(", ");

    document.getElementById("ticketSnacks").textContent =
        ticket.snacks.length > 0
            ? ticket.snacks.map(s => s.name + " x" + s.quantity).join(", ")
            : "No snacks";

    document.getElementById("ticketPayment").textContent = ticket.paymentMethod;
    document.getElementById("ticketTotal").textContent = "₹" + ticket.total;

    // Generate QR code
    const qrArea = document.getElementById("ticketQR");
    qrArea.innerHTML = "";

    if (typeof QRCode !== "undefined") {
        const qrDetails =
            "CINEBOOK TICKET\n" +
            "Booking ID: " + ticket.bookingId + "\n" +
            "Movie: " + ticket.movie + "\n" +
            "Date: " + ticket.date + "\n" +
            "Time: " + ticket.time + "\n" +
            "Seats: " + ticket.seats.join(", ") + "\n" +
            "Total: Rs." + ticket.total;

        new QRCode(qrArea, {
            text: qrDetails,
            width: 160,
            height: 160
        });
    } else {
        qrArea.textContent = "QR code library could not load. Please check your internet connection.";
    }

    confirmationSection.scrollIntoView({ behavior: "smooth" });
}


// ==============================
// DASHBOARD
// ==============================

function displayDashboard() {
    const bookings = getBookings();

    let totalTickets = 0;
    let totalSpent = 0;

    bookings.forEach(booking => {
        totalTickets += Array.isArray(booking.seats)
            ? booking.seats.length
            : 0;

        totalSpent += Number(booking.total) || 0;
    });

    document.getElementById("dashboardBookings").textContent =
        bookings.length;

    document.getElementById("dashboardTickets").textContent =
        totalTickets;

    document.getElementById("dashboardSpent").textContent =
        "₹" + totalSpent;

    const history = document.getElementById("dashboardHistory");
    history.innerHTML = "";

    if (bookings.length === 0) {
        history.textContent = "No bookings yet. Book your first movie!";
        return;
    }

    bookings.slice().reverse().forEach(booking => {
        const card = document.createElement("div");
        card.className = "dashboard-booking-card";

        const title = document.createElement("h3");
        title.textContent = booking.movie;

        const id = document.createElement("p");
        id.textContent = "Booking ID: " + (booking.bookingId || "Older booking");

        const date = document.createElement("p");
        date.textContent = "Date: " + booking.date;

        const time = document.createElement("p");
        time.textContent = "Time: " + booking.time;

        const seats = document.createElement("p");
        seats.textContent = "Seats: " +
            (Array.isArray(booking.seats) ? booking.seats.join(", ") : "");

        const total = document.createElement("p");
        total.textContent = "Total: ₹" + (booking.total || 0);

        card.append(title, id, date, time, seats, total);
        history.appendChild(card);
    });
}


// ==============================
// DASHBOARD BUTTON
// ==============================

document.getElementById("dashboardBtn").addEventListener("click", function () {
    hideAllSections();

    displayDashboard();

    dashboardSection.style.display = "block";
    dashboardSection.scrollIntoView({ behavior: "smooth" });
});


// ==============================
// DASHBOARD HOME BUTTON
// ==============================

document.getElementById("dashboardHomeBtn").addEventListener("click", function () {
    hideAllSections();
    document.getElementById("home").scrollIntoView({ behavior: "smooth" });
});


// ==============================
// PRINT TICKET
// ==============================

document.getElementById("printTicketBtn").addEventListener("click", function () {
    window.print();
});


// ==============================
// HOME BUTTON
// ==============================

document.getElementById("homeBtn").addEventListener("click", function () {
    hideAllSections();

    selectedMovie = null;
    selectedSeats = [];
    currentSnacks = [];
    currentTotal = 0;

    document.getElementById("home").scrollIntoView({ behavior: "smooth" });
});


// ==============================
// BOOKING HISTORY AND CANCELLATION
// ==============================

document.getElementById("historyBtn").addEventListener("click", function () {
    const bookings = getBookings();

    if (bookings.length === 0) {
        alert("You have no bookings yet!");
        return;
    }

    let message = "MY BOOKINGS\n\n";

    bookings.forEach((booking, index) => {
        message +=
            (index + 1) + ". " + booking.movie +
            "\nBooking ID: " + (booking.bookingId || "Older booking") +
            "\nDate: " + booking.date +
            "\nTime: " + booking.time +
            "\nSeats: " + (booking.seats || []).join(", ") +
            "\nTotal: ₹" + (booking.total || 0) +
            "\n\n";
    });

    message += "Enter the booking number to cancel.\n";
    message += "Enter 0 to close.";

    const choice = prompt(message);

    if (choice === null || choice.trim() === "") {
        return;
    }

    const bookingNumber = Number(choice);

    if (bookingNumber === 0) {
        return;
    }

    if (
        !Number.isInteger(bookingNumber) ||
        bookingNumber < 1 ||
        bookingNumber > bookings.length
    ) {
        alert("Invalid booking number!");
        return;
    }

    const bookingToCancel = bookings[bookingNumber - 1];

    const confirmCancel = confirm(
        "Are you sure you want to cancel this complete booking?\n\n" +
        "Movie: " + bookingToCancel.movie +
        "\nSeats: " + (bookingToCancel.seats || []).join(", ") +
        "\nTotal: ₹" + (bookingToCancel.total || 0)
    );

    if (!confirmCancel) {
        return;
    }

    bookings.splice(bookingNumber - 1, 1);

    localStorage.setItem("cinebookBookings", JSON.stringify(bookings));

    alert(
        "Booking cancelled successfully!\n" +
        "The selected seats are now available again."
    );
});


// ==============================
// INITIAL DISPLAY
// ==============================

displaySnacks();
displayMovies();

