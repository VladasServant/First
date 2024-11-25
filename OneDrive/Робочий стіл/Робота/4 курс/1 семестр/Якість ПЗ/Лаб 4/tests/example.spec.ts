import { test, expect } from '@playwright/test';

test("Login User with correct email and password", async ({ page }) => {
  await page.goto("http://automationexercise.com");
  await expect(page).toHaveTitle(/Automation Exercise/);
  await page.click('a[href="/login"]');
  await expect(page.locator('h2:has-text("Login to your account")')).toBeVisible();
  await page.fill('input[data-qa="login-email"]', "Den@mail.ru");
  await page.fill('input[data-qa="login-password"]', "DEN");
  await page.click('button[data-qa="login-button"]');
  await expect(page.locator('a:has-text("Logged in as")')).toBeVisible();
  //await page.click('a[href="/delete_account"]');
  //await expect(page.locator('h2:has-text("ACCOUNT DELETED!")')).toBeVisible();
});

test("Logout User", async ({ page }) => {
  await page.goto("http://automationexercise.com");
  await expect(page).toHaveTitle(/Automation Exercise/);
  await page.click('a[href="/login"]');
  await expect(page.locator('h2:has-text("Login to your account")')).toBeVisible();
  await page.fill('input[data-qa="login-email"]', "Den@mail.ru");
  await page.fill('input[data-qa="login-password"]', "DEN");
  await page.click('button[data-qa="login-button"]');
  await expect(page.locator('text=Logged in as')).toBeVisible();
  await page.click('a[href="/logout"]');
  await expect(page.locator('h2:has-text("Login to your account")')).toBeVisible();
});

test("Register User with existing email", async ({ page }) => {
  await page.goto("http://automationexercise.com");
  await expect(page).toHaveTitle(/Automation Exercise/);
  await page.click('a[href="/login"]');
  await expect(page.locator('h2:has-text("New User Signup!")')).toBeVisible();
  await page.fill('input[data-qa="signup-name"]', "Den");
  await page.fill('input[data-qa="signup-email"]', "Den@mail.ru");
  await page.click('button[data-qa="signup-button"]');
  await expect(page.locator('p:has-text("Email Address already exist!")')).toBeVisible();
});

test("Add to cart from Recommended items", async ({ page }) => {
  await page.goto('http://automationexercise.com');
  await page.evaluate(() => window.scrollTo(0, document.body.scrollHeight));
  const recommendedItemsSection = await page.locator('h2:has-text("recommended items")');
  await expect(recommendedItemsSection).toBeVisible();
  const productContainer = await page.locator('#recommended-item-carousel .active.left .productinfo:has(p:has-text("Men Tshirt"))');
  await productContainer.locator('a:has-text("Add to cart")').click();
  await page.click('a:has-text("View Cart")');
  const cartProduct = await page.locator('.table-responsive .cart_description:has(a:has-text("Men Tshirt"))');
  await expect(cartProduct).toBeVisible();
});

test("Add review on product", async ({ page }) => {
  await page.goto("http://automationexercise.com");
  await page.click('a[href="/products"]');
  await expect(page).toHaveURL(/products/);
  await expect(page.locator('h2:has-text("All Products")')).toBeVisible();
  await page.click('a:has-text("View Product")');
  await expect(page.locator('a:has-text("Write Your Review")')).toBeVisible();
  await page.fill('#name', "Den");
  await page.fill('#email', "Den@mail.ru");
  await page.fill('#review', "This is a test review.");
  await page.click('button:has-text("Submit")');
  await expect(page.locator('span:has-text("Thank you for your review.")')).toBeVisible();
});