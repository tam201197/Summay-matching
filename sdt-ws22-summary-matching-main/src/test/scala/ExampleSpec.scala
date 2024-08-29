import org.scalatest.flatspec.AnyFlatSpec

/**
 *
 * @Authors: Artur
 */

class ExampleSpec extends AnyFlatSpec {
  //With this input I expect this output...
  val summaries_path = "./src/main/resources/summary-files"
  val jar_path = "./src/main/resources/jar-files/classes.jar"
  val out_put = "./src/main/resources/output"
  val object_to_test = new SearchForDependencies(jar_path = jar_path, summaries_path = summaries_path, output_path = out_put)
  object_to_test.execute()
  "Class with dependencies" can "have size more than 0" in {
    assert(object_to_test.classWithDependencies.empty != 0)
  }

  "class with match summary" can "have size more than 0" in {
    assert(object_to_test.classWithMatchSummary.empty != 0)
  }

  "The jar file " must "be included!" in{
    assert(object_to_test.jar_path == jar_path)
  }

  "inside classWithMatchSummary" must "class ... must be included" in {

    print("list of match summaries: " + object_to_test.classWithMatchSummary)
    print("\nlist of dependencies: " + object_to_test.classWithDependencies)
  }

  it should "contain five cases where dependencies exist" in {
    val size_of_dependencies = object_to_test.get_classWithDependencies_map_size()

    assert(size_of_dependencies == 7)
  }

  it should "contain five cases where summaries exist" in {
    val size_of_summaries = object_to_test.get_classWithMatchSummary_map_size()

    assert(size_of_summaries == 7)
  }

  it should "contain TestClassSummary in list of the summaries" in {
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.TestClassSummary"))
  }

  it should "contain TestClassSummary2 in list of the summaries" in {
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.TestClassSummary2"))
  }

  it should "contain TestClassSummary3 in list of the summaries" in {
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.TestClassSummary3"))
  }

  it should "contain TestClassSummary4 in list of the summaries" in {
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.TestClassSummary4"))
  }

  it should "contain TestClassSummary5 in list of the summaries" in {
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.TestClassSummary5"))
  }

  "The file of match summaries" must "contain a message class" in{
    assert(object_to_test.classWithMatchSummary.contains("com.example.std_app.Message_m"))
  }





}