async function loadDashboard() {

    try {

        const farmers = await fetch("/farmers").then(res => res.json());
        const officers = await fetch("/officers").then(res => res.json());
        const regions = await fetch("/regions").then(res => res.json());
        const tickets = await fetch("/tickets").then(res => res.json());

        document.getElementById("farmerCount").textContent = farmers.length;
        document.getElementById("officerCount").textContent = officers.length;
        document.getElementById("regionCount").textContent = regions.length;
        document.getElementById("ticketCount").textContent = tickets.length;

    } catch (error) {

        console.error("Dashboard loading error:", error);

    }
}

loadDashboard();