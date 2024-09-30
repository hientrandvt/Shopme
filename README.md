![App Architecture](https://github.com/NileshJarad/SearchImage/raw/master/docs/app_architecture.png)
<sub>Image taken from [NileshJarad's GitHub](https://github.com/NileshJarad)</sub>

# Clean Architecture Structure for ShopMe Project
## 1. Layered Structure
* Presentation Layer (app module)
    * Files: MainActivity.kt, HomeScreen.kt, HomeViewModel.kt...
    * Purpose: Manages the user interface and user interactions, updating the UI based on data changes.
* Domain Layer (domain module)
    * Files: ProductUseCases.kt, ProductRepository.kt, ProductEntity.kt...
    * Purpose: Contains business logic and defines core functionality, independent of frameworks.
* Data Layer (data module)
    * Files: ApiProductService.kt, ProductRepositoryImpl.kt, ProductData.kt..
    * Purpose: Handles data access and manipulation, implementing the repository interfaces from the domain layer.
  
## 2. Dependency Rule
* Outer layers depend on inner layers, but not vice versa. The app module relies on the domain for use cases, while the data module implements the domain's repository interfaces.

## 3. Separation of Concerns
* Each layer has a distinct responsibility:
    * Presentation Layer: UI management
    * Domain Layer: Business logic
    * Data Layer: Data retrieval and storage

## 4. Dependency Injection
* The use of dependency injection, which decouples components and enhances testability.

## 5. Modularity
* The project is modular, encapsulating features within separate modules (app, data, domain), promoting organization and scalability.


# Unit Testing

## Test Files

- **Data Module**:
  - CartRepositoryImplTest
  - ProductRepositoryImplTest

- **Domain Module**:
  - AddProductToCartTest
  - GetProductsInCartTest
  - GetProductDetailTest
  - GetProductListTest

## Libraries Used

- Jetpack Compose
- Room
- Hilt (for Dependency Injection)
- Retrofit
- Coroutines
