// src/main/resources/static/js/script.js

// =========================
// Hero Parallax Scroll Effect
// =========================
document.addEventListener("scroll", () => {
  const scrollY = window.scrollY;
  const logos = document.querySelectorAll(".hero-logo");

  logos.forEach((logo, index) => {
    const direction = index % 2 === 0 ? 1 : -1; // left & right opposite
    logo.style.transform = `translateY(${scrollY * 0.1 * direction}px)`;
  });
});

// =========================
// Scroll Reveal + Stats Counter
// =========================
document.addEventListener("DOMContentLoaded", function () {
  document.documentElement.classList.add("js"); // mark JS available

  const revealItems = document.querySelectorAll(
    ".page-section, .why-choose, .about, .section-title"
  );
  const stats = document.querySelectorAll(".stats .card h2");

  window.addEventListener("scroll", function() {
    const navbar = document.querySelector(".navbar");
    if (window.scrollY > 50) {
      navbar.classList.add("scrolled");
    } else {
      navbar.classList.remove("scrolled");
    }
  });


  // Counter animation helper
  function animateCounter(el, target) {
    let current = 0;
    const increment = Math.ceil(target / 100); // steps
    const speed = 20; // ms per step

    const update = () => {
      current += increment;
      if (current > target) current = target;
      el.textContent = current + (el.dataset.suffix || "");
      if (current < target) setTimeout(update, speed);
    };
    update();
  }

  const observer = new IntersectionObserver(
    (entries) => {
      entries.forEach((entry) => {
        if (entry.isIntersecting) {
          entry.target.classList.add("visible");

          // If it's the stats section → run counters
          if (entry.target.classList.contains("stats")) {
            stats.forEach((el) => {
              const target = parseInt(el.dataset.target, 10);
              if (!isNaN(target)) {
                animateCounter(el, target);
              }
            });
          }

          observer.unobserve(entry.target); // run once per element
        }
      });
    },
    { threshold: 0.18 }
  );

  revealItems.forEach((item) => observer.observe(item));
});
