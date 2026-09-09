# 🎬 Cinema Ticket Management System

A console-based Java application that simplifies cinema ticket booking — built with **classes**, **arrays**, and **control statements**.

**Author:** Jayakavya K
**S.No:** 37 &nbsp;|&nbsp; **Roll No:** VH15001 &nbsp;|&nbsp; **Register No:** 113025205037 &nbsp;|&nbsp; **Batch:** 13A

---

## About

This project models a simple cinema box office. It records each customer's name, chosen ticket category, and number of seats, then automatically calculates the amount due based on category pricing.

## Features

- 🎟️ Book tickets for **Silver**, **Gold**, or **Platinum** categories
- 👤 Store customer name, category, seat count, and amount in a `Customer` array
- 💰 Auto-calculate ticket price per booking using a `switch` statement
- 📋 View all bookings in a formatted table
- 📊 View total revenue collected across all bookings
- 🪑 View a category-wise seat summary

## Ticket Pricing

| Category | Price per Seat |
|----------|-----------------|
| Silver   | Rs. 150 |
| Gold     | Rs. 250 |
| Platinum | Rs. 400 |

## Concepts Used

- **Classes & Objects:** `Customer` (data holder) and `TicketBookingManager` (business logic)
- **Arrays:** `Customer[] bookings` stores up to 50 bookings for a show
- **Control Statements:** `switch` for pricing logic, `if-else` for validation, `for`/`while` loops for iteration and the menu loop

## How to Run

```bash
javac src/CinemaTicketManagement.java -d bin
java -cp bin CinemaTicketManagement
```

## Sample Menu

```
============================================
   CINEMA TICKET MANAGEMENT SYSTEM
============================================

1. Book a Ticket
2. View All Bookings
3. View Total Revenue
4. View Category-wise Seat Summary
5. Exit
Enter your choice:
```

## Project Structure

```
cinema-ticket-management/
├── src/
│   └── CinemaTicketManagement.java
├── index.html          (project showcase website)
└── README.md
```

---
*Submitted as part of academic coursework — Batch 13A.*
