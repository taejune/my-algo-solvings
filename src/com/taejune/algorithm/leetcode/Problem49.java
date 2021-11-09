package com.taejune.algorithm.leetcode;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/

public class Problem49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> answer = new ArrayList<>();

            Map<String, List<String>> m = new HashMap<>();
            for (String s : strs) {
                int[] characters = new int[s.length()];
                for (int i = 0; i < s.length(); i++) {
                    characters[i] = s.charAt(i) - 'a' + 1;
                }

                Arrays.sort(characters);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    sb.append(characters[i]);
                }

                List<String> words = m.getOrDefault(sb.toString(), new ArrayList<>());
                words.add(s);
                m.put(sb.toString(), words);
            }

            for (List<String> words : m.values()) {
                answer.add(words);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        List<List<String>> case01 = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(case01);

        List<List<String>> case02 = new Solution().groupAnagrams(new String[]{""});
        System.out.println(case02);
        // [[""]]

        List<List<String>> case03 = new Solution().groupAnagrams(new String[]{"a"});
        System.out.println(case03);
        // [["a"]]

        List<List<String>> case04 = new Solution().groupAnagrams(new String[]{"ac", "a"});
        System.out.println(case04);
        // [["ac"],["a"]]

        List<List<String>> case05 = new Solution().groupAnagrams(new String[]{
                "tho", "tin", "erg", "end", "pug", "ton", "alb", "mes", "job", "ads", "soy", "toe", "tap",
                "sen", "ape", "led", "rig", "rig", "con", "wac", "gog", "zen", "hay", "lie", "pay", "kid",
                "oaf", "arc", "hay", "vet", "sat", "gap", "hop", "ben", "gem", "dem", "pie", "eco", "cub",
                "coy", "pep", "wot", "wee"});
        System.out.println(case05);
        // [["wee"],["pep"],["cub"],["eco"],["dem"],["gap"],["vet"],["job"],["ben"],["toe"],["hay","hay"],["mes"],
        // ["ads"],["alb"],["wot"],["gem"],["oaf"],["hop"],["ton"],["pug"],["end"],["con"],["coy"],["sat"],["soy"],
        // ["pay"],["tin"],["pie"],["ape"],["tho"],["erg"],["sen"],["rig","rig"],["tap"],["wac"],["gog"],["led"],
        // ["zen"],["arc"],["lie"],["kid"]]

        List<List<String>> case06 = new Solution().groupAnagrams(new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"});
        System.out.println(case06);
        // [["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"],["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]]

        List<List<String>> case07 = new Solution().groupAnagrams(new String[]{
                "multiplying", "flamboyantly", "profession", "loft", "voluntary", "fudges", "swore",
                "flanks", "diet", "pamphlets", "dispatchers", "afterbirths", "boutiques", "motifs",
                "massenet", "translator", "cup", "mountbatten", "constipated", "monotonically", "stability",
                "reenact", "pols", "bowed", "berthed", "wreathing", "ecclesiastes", "stylistically",
                "chandigarh", "carpenters", "freestyle", "reflexively", "palimpsest", "ampul", "deliberates",
                "reactor", "metals", "deforests", "coloring", "guadalajara", "ra", "natural", "creepies",
                "dankly", "disqualifies", "hometowns", "disengages", "papergirls", "phrenology", "receptors",
                "concessions", "judgements", "hummocked", "whiner", "repaying", "selvaged", "wattest",
                "throats", "persecutor", "seagram", "akimbo", "bureaucratically", "stepbrothers",
                "transubstantiation", "enjoy", "couping", "rhizome", "paramount", "raccoon", "hafiz",
                "admiration", "snakebite", "rumors", "lasting", "ammo", "acquirable", "harvard",
                "monomaniac", "tonnages", "rakish", "doses", "beneficently", "essential", "statistically",
                "consultancies", "cliffs", "ringleaders", "effusively", "condescension", "lime", "helplessness",
                "jerking", "schemers", "glosses", "grinding", "bacterial", "stone", "disintegrate", "enormous",
                "miniaturized", "impetuous", "nude", "fumbles", "corpora", "beneficiaries", "powerlessly",
                "judgment", "doctorates", "decade", "gracelessly", "pollard", "sangfroid", "overspecialized",
                "mews", "repaired", "islamics", "stinks", "jasmine", "formulate", "chloride", "septembers",
                "congress", "scrap", "threshed", "mechanizing", "egotist", "bicepses", "grabs", "pudding",
                "mariachis", "kong", "canonicals", "bumpiest", "mossiest", "obsessing", "floral", "deed",
                "baron", "rubbishes", "refuting", "remainder", "woodsier", "kapok", "instruments",
                "matriculated", "cub", "marched", "librettos", "splendor", "wyo", "silkworm", "llewellyn",
                "anesthesia", "nagged", "wellsprings", "stationing", "airedale", "axed", "decors", "smug",
                "sucking", "humanoid", "backside", "sacramento", "swinburne", "sirups", "oakum", "fumigating",
                "valarie", "flotilla", "crevices", "surmountable", "inquiringly", "spotters", "ferrets",
                "bulldoze", "combatant", "shane", "satiny", "camshafts", "carped", "published", "crooners",
                "imperceptible", "dispatches", "examples", "earmuffs", "gramme", "lung", "plied", "fallowing",
                "liberties", "cratered", "mauling", "patronizes", "flaked", "inspects", "cusp", "wakened",
                "outbalanced", "speckled", "compose", "oleaginous", "heiresses", "cashiers", "ark", "premises",
                "narrowness", "computations", "mongolism", "steamy", "informant", "dice", "compounded", "acrylic",
                "scrunch", "penlight", "imputations", "clerics", "dressmakers", "dangers", "paying", "tunes",
                "murkiest", "effusive", "misanthropist", "alloying", "terrorize", "costner", "virginian",
                "pampering", "sufficient", "incisors", "culotte", "gusting", "relapsed", "headstrong",
                "backspaced", "engaged", "strikingly", "schemed", "diversifying", "hyper", "accountant",
                "nosegay", "occluded", "underarm", "cyclically", "amuck", "cutlet", "perpetrators", "malfeasance",
                "pompey", "monolingual", "cutthroats", "hails", "delimit", "grudging", "heraldic", "doc",
                "melanges", "alerted", "disappearance", "sharpe", "livers", "shoemaker", "wealthiness",
                "antipersonnel", "serbia", "guzzled", "dmitri", "threshes", "skyrocketed", "ionized", "amend",
                "grotesques", "containers", "platonism", "tabbies", "lames", "infatuation", "locus", "acquaintance",
                "mouthfuls", "coroners", "glands", "bilges", "queasy", "dewitt", "pidgin", "bicentennial", "radish",
                "unlawfully", "junketed", "use", "negotiate", "hailing", "typo", "sanity", "mallard", "incubating",
                "typed", "midterm", "glacially", "maestro", "reincarnate", "transpiring", "strolling", "verbena",
                "trapper", "flyers", "helmsman", "mischievous", "pendants", "rosalie", "beatles", "carpals",
                "crinkling", "recapped", "command", "rolando", "union", "bert", "hera", "mimeographing", "vulgarly",
                "pertinacious", "markham", "borodin", "malevolence", "resuscitating", "interrelationship", "indulging",
                "earthling", "wishers", "bludgeoned", "canvassed", "canute", "microsoft", "bikes", "hialeah",
                "mountains", "physicals", "overstepped", "cornstalks", "temperament", "patriots", "irreverently",
                "blitz", "firewall", "sharpshooter", "fizzing", "handicappers", "ultrasonic", "halftime", "mcnamara",
                "bratislava", "clink", "anaesthetized", "desmond", "vaccines", "ed", "peccaries", "mantillas",
                "indemnifications", "retypes", "scenarios", "regressed", "sauced", "wins", "kresge", "sparkled",
                "miseries", "reformed", "moss", "tethers", "outsizes", "contests", "funner", "wagons", "shortness",
                "drivers", "estate", "coquettish", "favorites", "watersides", "egos", "foiling", "dismaying",
                "obligating", "lit", "fiord", "s", "cautioning", "ararat", "creditable", "caerphilly", "tinkers",
                "arrayed", "transgressions", "temperas", "cantaloup", "suffragettes", "impacts", "workplaces",
                "hostlers", "feebly", "regular", "tarring", "vetoes", "snack", "signifying", "frisk", "diacritic",
                "thea", "spirally", "floodlit", "minibike", "concepts", "sustain", "dissociated", "vassaling",
                "credenza", "adjacent", "blithe", "culture", "languors", "bunker", "bucked", "pulsar", "chromosome",
                "vicky", "viewfinders", "accosts", "nominal", "kshatriya", "reamer", "amorous", "signify", "nuttiest",
                "tomlin", "resume", "greatest", "learners", "brashness", "plaiting", "feminists", "oddness",
                "facelifts", "seaport", "interdicting", "renewed", "reprogrammed", "smoulder", "bernhardt", "wangled", "choir", "listens", "crusty", "heavenward", "failures", "per", "proctors", "edifice", "trespassing", "displeased", "fuddle", "partner", "motor", "editorialize", "fishbowls", "rangier", "chats", "wreckage", "covet", "guzzlers", "scapegoats", "silicates", "szymborska", "biplanes", "necktie", "optic", "macao", "hyped", "medications", "nemesis", "mandates", "splodge", "resins", "angelica", "gaffed", "atavistic", "petioles", "anxiety", "killjoys", "misuses", "nabobs", "queens", "conceivably", "castling", "haltingly", "serapes", "whizz", "punctuating", "seaweed", "eunuchs", "bidets", "midpoints", "breaded", "flunky", "tithe", "urbanized", "balcony", "winked", "goldener", "robotics", "manichean", "garrison", "rattles", "songbirds", "haldane", "bankrupting", "whitehall", "questioningly", "gofers", "perfection", "ghostwriting", "mosley", "swimmer", "soliloquizing", "freeholder", "draining", "outfoxed", "flanneling", "biggest", "licked", "trendier", "impoverishing", "commits", "advisement", "unclasping", "basking", "rico", "cagiest", "auspicious", "legislate", "trevor", "chevrons", "proceeds", "steward", "bloating", "resourcefully", "anodynes", "gallivant", "modifier", "mugs", "verizon", "kip", "potties", "blaine", "thud", "chastest", "hibernate", "pastor", "rovers", "schmaltz", "discomfited", "prefabricating", "cruisers", "mutts", "sputtered", "doable", "sheik", "laocoon", "politicize", "wretcheder", "rankling", "sides", "docs", "gluing", "pickaxed", "pedagogical", "describe", "spec", "toni", "unimaginative", "guidance", "distorter", "congeniality", "harvests", "daniel", "irrigates", "mallomars", "sevenths", "decisive", "stylish", "angleworm", "dido", "conventing", "roweling", "zing", "relish", "prearrange", "atheistic", "goldsmiths", "setbacks", "topcoat", "condoled", "compensate", "heavenly", "voyeurs", "judases", "shortchanging", "trooped", "badmouths", "requites", "immigrating", "opticians", "swellheads", "sated", "cannibalizes", "continental", "frothed", "curios", "unlike", "replications", "cormorants", "scaramouch", "thingamajig", "plunged", "ainu", "bilbao", "glops", "shoplifting", "basses", "clark", "nerving", "bosom", "cruciform", "throttle", "pokey", "envelope", "medicaid", "indifferent", "fluency", "echelons", "espying", "twirlers", "cathryn", "concluding", "punctilious", "churchgoers", "comparing", "persimmons", "ducal", "flatt", "wearer", "mandarin", "iphigenia", "rub", "playrooms", "lorrie", "carries", "incapacitates", "earn", "electrified", "adrenal", "marcher", "phrases", "antibiotic", "eventually", "balconies", "carton", "toggle", "molded", "protrusions", "croquettes", "outwears", "reciprocals", "poisons", "homogenized", "sufi", "tartuffe", "retractable", "schoolhouses", "megaliths", "transliteration", "surreys", "awaited", "wetted", "participial", "subsidized", "anticipates", "capulet", "equate", "observable", "excrescences", "oceanographers", "devise", "beds", "tolling", "quilts", "hierarchical", "cloches", "relative", "blossoming", "woodsheds", "at", "stilling", "spacial", "sublet", "doggoning", "vermilion", "rhiannon", "yangon", "strictest", "podding", "hittite", "stiffened", "suited", "admonitions", "occupational", "regulation", "fetter", "panelists", "chillers", "irma", "aspirant", "ayyubid", "exceptionable", "drunken", "tread", "carpel", "vests", "countered", "aeroflot", "assigned", "exhorted", "attentions", "euclidean", "cellars", "anons", "exhausting", "body", "clattering", "numbered", "battled", "ventilate", "sculptured", "imelda", "solemner", "unimpaired", "sequesters", "preachier", "gums", "malignantly", "luftwaffe", "intact", "reinforcement", "misses", "durante", "calculates", "susanne", "compass", "beryls", "filibuster", "entailing", "eclectically", "shivers", "letting", "inflammations", "asseverating", "psychos", "cyrus", "hoop", "wondrous", "ritual", "photogenic", "josue", "magnifier", "spitted", "theorize", "notebooks", "pacing", "proportions", "secretary", "cavity", "scampering", "recline", "snyder", "sugariest", "rowdiest", "discommodes", "rory", "arteries", "outranks", "inflect", "latticework", "abusive", "gaslights", "cactuses", "overreaches", "mushiest", "lagrange", "sciatica", "bulging", "apse", "lucked", "burying", "annoyed", "sub", "thoroughfares", "offshore", "villa", "vermont", "akron", "rep", "stutterer", "stendhal", "redeemer", "research", "lithium", "sprucer", "unavailing", "bulldozer", "herringboned", "misapply", "gybes", "frobisher", "snippier", "career", "rhymes", "bolivar", "esq", "alison", "backers", "motleyest", "toots", "infelicitous", "swaying", "telecommunication", "reproves", "tersely", "joyriding", "snuffles", "crick", "jut", "preppies", "testifies", "retooling", "grandstands", "riveted", "dillydally", "flute", "procreate", "peppier", "decorating", "alcoholics", "langland", "cohort", "eroded", "sonnets", "consent", "jackrabbits", "spadework", "lunchboxes", "anesthesiology", "stubbornest", "quixotism", "ambidextrously", "return", "stockbroker", "aqueduct", "fluent", "praises", "bemoans", "missourians", "firths", "bluenoses", "sprained", "workbooks", "wobblier", "bereavement", "institutionalizing", "shindig", "subtitled", "knifing", "acrylics", "cortez", "muled", "infer", "integrates", "grid", "sentimentalizing", "liberia", "flamethrower", "entity", "detoxify", "copra", "meridians", "milieus", "atrium", "grays", "resultants", "mincemeat", "concentrates", "viscountesses", "connoting", "jerkily", "tiger", "engendered", "spectacular", "fritter", "billions", "puers", "wormwood", "genuine", "sticking", "monograph", "wander", "evacuated", "bargained", "syphilitics", "logging", "model", "entrapped", "tirade", "blondie", "windmills", "incompetent", "battlegrounds", "leaden", "conjectures", "testimonials", "soil", "downcast", "polio", "remounted", "rekindle", "disingenuous", "paternalistic", "adobes", "bibliophile", "sindbad", "gizmo", "booing", "thoughtlessness", "tennis", "skillets", "woefullest", "exult", "briggs", "womanize", "wenches", "radiate", "hiccups", "alexandra", "hammer", "indicator", "hensley", "adulteress", "tiptoes", "urologists", "peters", "endorse", "repulses", "squealed", "adjudicating", "swift", "notionally", "everything", "flown", "rediscovered", "spinner", "lividly", "lyra", "storeroom", "hallelujahs", "term", "stabbings", "wite", "corrine", "usefully", "masters", "subhead", "gallantry", "mercuries", "navy", "cristina", "pray", "salamander", "asters", "purgatory", "recidivists", "cognac", "springsteen", "multitude", "wilberforce", "drizzling", "ramification"});
        System.out.println(case07);
        // [["ramification"],["drizzling"],["recidivists"],["purgatory"],["asters"],["navy"],["mercuries"],["subhead"],["wite"],["stabbings"],["term"],["hallelujahs"],["lividly"],["repulses"],["indicator"],["alexandra"],["corrine"],["hiccups"],["womanize"],["woefullest"],["skillets"],["booing"],["sindbad"],["conjectures"],["leaden"],["battlegrounds"],["adulteress"],["incompetent"],["windmills"],["blondie"],["model"],["logging"],["syphilitics"],["bargained"],["evacuated"],["wander"],["monograph"],["wormwood"],["puers"],["spectacular"],["engendered"],["concentrates"],["mincemeat"],["resultants"],["milieus"],["meridians"],["copra"],["detoxify"],["flamethrower"],["sentimentalizing"],["cortez"],["acrylics"],["knifing"],["subtitled"],["shindig"],["wobblier"],["bemoans"],["praises"],["fluent"],["aqueduct"],["return"],["quixotism"],["lunchboxes"],["spadework"],["consent"],["cohort"],["langland"],["peppier"],["dillydally"],["grandstands"],["spinner"],["testifies"],["springsteen"],["preppies"],["snuffles"]...


    }
}
