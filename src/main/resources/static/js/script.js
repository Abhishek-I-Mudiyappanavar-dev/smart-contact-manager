document.addEventListener("DOMContentLoaded", () => {
    const btn = document.querySelector('#theme_toggle_btn');
    if (!btn) return;

    // Local tracker initialization using inline logical OR mapping
    let current = localStorage.getItem("theme") || "light";
    
    // Core structural synchronization closure
    const sync = (t) => {
        document.documentElement.classList.toggle("dark", t === "dark");
        localStorage.setItem("theme", t);
        if (btn.querySelector("span.sr-only")) {
            btn.querySelector("span.sr-only").textContent = `Switch to ${t === "dark" ? "light" : "dark"} mode`;
        }
        current = t;
    };

    // Initialize state immediately on page layout execution
    sync(current);

    // Register simple structural execution switch listener
    btn.addEventListener("click", () => sync(current === "dark" ? "light" : "dark"));
});
