# Test Execution Guide

## How to Run All Tests

### Option 1: Using Maven (Recommended)
```bash
cd c:\Users\ASUS\IdeaProjects\lab-java-intro-to-testing-openbank-2025\Intro_to_testing
mvn test
```

### Option 2: Using IntelliJ IDEA
1. Right-click on the `src/test/java` folder
2. Select "Run 'Tests in src/test/java'" 
3. All tests will execute and display results

### Option 3: Run Individual Test Classes
In IntelliJ IDEA:
- Right-click on any `*Test.java` file
- Select "Run [TestClassName]"

---

## Test Results Expected

All 51 tests should **PASS**:

- ✅ Instruction1Test: 4/4 tests passing
- ✅ Java_keywordsTest: 4/4 tests passing
- ✅ PlayerTest: 9/9 tests passing
- ✅ WarriorTest: 8/8 tests passing
- ✅ ElfTest: 11/11 tests passing
- ✅ WizardTest: 15/15 tests passing

---

## Key Files Modified/Created

### Main Code (src/main/java)
- `Instruction1.java` - ✅ Already complete
- `Java_keywords.java` - ✅ Already complete
- `Player.java` - ✅ Already complete
- `Warrior.java` - ✅ Already complete
- `Elf.java` - ✅ Already complete
- `Wizard.java` - ✅ **UPDATED** with SpellLibrary dependency and castRandomSpell()
- `SpellLibrary.java` - ✅ **NEW** interface for dependency injection

### Test Code (src/test/java)
- `Instruction1Test.java` - ✅ Already complete
- `Java_keywordsTest.java` - ✅ Already complete
- `PlayerTest.java` - ✅ **NEW** comprehensive test suite
- `WarriorTest.java` - ✅ **NEW** comprehensive test suite
- `ElfTest.java` - ✅ **NEW** comprehensive test suite
- `WizardTest.java` - ✅ **NEW** comprehensive test suite with Mockito integration

---

## Mockito Dependency

The pom.xml already includes Mockito:
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>
```

No additional configuration needed!

---

## Test Coverage Summary

### Instruction1Test
- Odd number generation with various inputs
- Edge cases (0, 1, even, odd)

### Java_keywordsTest
- Keyword detection in sentences
- Empty string handling
- Multiple keywords

### PlayerTest
- Property initialization and access
- Health restoration on life loss
- Attack mechanics
- Health checking and automatic life decrement
- Integration scenarios

### WarriorTest
- Warrior-specific properties (force)
- Conversion to Elf with force as speed
- Inherited Player functionality

### ElfTest
- Elf-specific properties (speed)
- All inherited Player functionality
- Property access and modification

### WizardTest
- Wizard-specific properties (spell)
- Constructor overloading with dependency injection
- Conversion to Elf with spell as speed
- **Mockito Tests:**
  - Mock SpellLibrary interface
  - Stub getRandomSpell() method
  - Verify method call exactly once
  - Assert correct return format
  - Test with different spell values
  - Edge case handling

---

## Next Steps (Optional)

If you want to extend the testing:

1. **Add integration tests** combining multiple game mechanics
2. **Add performance tests** for large-scale scenarios
3. **Add property-based tests** using libraries like QuickTheories
4. **Expand game logic** with additional features and corresponding tests

---

## Troubleshooting

**Tests not running?**
1. Ensure Java 17+ is installed (pom.xml specifies java 17)
2. Ensure Maven is installed and configured
3. Run `mvn clean compile` to rebuild the project
4. Check that all dependencies are downloaded: `mvn dependency:resolve`

**Import errors in tests?**
1. Right-click project → Maven → Reload Projects
2. Invalidate caches and restart IntelliJ
3. Ensure test sources are marked as test sources

**Mockito issues?**
1. Verify mockito-junit-jupiter is in pom.xml
2. Ensure @Mock and MockitoAnnotations.openMocks(this) are used
3. Check that SpellLibrary interface is available in classpath

